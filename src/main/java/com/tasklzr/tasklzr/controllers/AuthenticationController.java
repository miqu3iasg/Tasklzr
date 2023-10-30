package com.tasklzr.tasklzr.controllers;

import com.tasklzr.tasklzr.core.dtos.AuthenticationDTO;
import com.tasklzr.tasklzr.core.dtos.RegisterUserDTO;
import com.tasklzr.tasklzr.core.models.user.User;
import com.tasklzr.tasklzr.core.repositories.UserRepository;
import com.tasklzr.tasklzr.infra.security.service.TokenService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Retornando Forbidden 403, resolver para conseguir ter acesso as requisições
@RestController
public class AuthenticationController {
  final AuthenticationManager authenticationManager;
  final UserRepository repository;
  final TokenService tokenService;

  @Lazy
  public AuthenticationController(AuthenticationManager authenticationManager, UserRepository repository, TokenService tokenService) {
    this.authenticationManager = authenticationManager;
    this.repository = repository;
    this.tokenService = tokenService;
  }

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody AuthenticationDTO request) {
    var userNamePassword = new UsernamePasswordAuthenticationToken(request.login(), request.password());
    var auth = authenticationManager.authenticate(userNamePassword);

    var token = tokenService.generateToken((User) auth.getPrincipal());

    return ResponseEntity.ok(token);
  }

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody RegisterUserDTO request) {
    if(repository.findByLogin(request.login()) != null) return ResponseEntity.badRequest().build();

    String encryptedPassword = new BCryptPasswordEncoder().encode(request.password());
    var newUser = new User(request.login(), encryptedPassword, request.role());

    repository.save(newUser);

    return ResponseEntity.ok().build();
  }
}
