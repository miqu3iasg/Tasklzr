package com.tasklzr.tasklzr.controllers;

import com.tasklzr.tasklzr.core.dtos.AuthenticationDTO;
import com.tasklzr.tasklzr.core.dtos.RegisterUserDTO;
import com.tasklzr.tasklzr.core.models.programmer.Programmer;
import com.tasklzr.tasklzr.core.repositories.ProgrammerRepository;
import com.tasklzr.tasklzr.infra.security.service.TokenService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthenticationController {
  final AuthenticationManager authenticationManager;
  final ProgrammerRepository repository;
  final TokenService tokenService;

  @Lazy
  public AuthenticationController(AuthenticationManager authenticationManager, ProgrammerRepository repository, TokenService tokenService) {
    this.authenticationManager = authenticationManager;
    this.repository = repository;
    this.tokenService = tokenService;
  }

  @PostMapping("/login")
  ResponseEntity login(@RequestBody AuthenticationDTO request) {
    Programmer programmer = new Programmer();
    if(repository.findByEmail(request.email()) == null) return ResponseEntity.badRequest().body("Programmer not found.");

    try {
      var userNamePassword = new UsernamePasswordAuthenticationToken(request.email(), request.password());
      var auth = authenticationManager.authenticate(userNamePassword);

      var token = tokenService.generateToken((Programmer) auth.getPrincipal());

      return ResponseEntity.ok(token);

    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Login failled");
    }

  }

  @PostMapping("/register")
  ResponseEntity register(@RequestBody RegisterUserDTO request) {
    if(repository.findByEmail(request.email()) != null) return ResponseEntity.badRequest().build();

    String encryptedPassword = new BCryptPasswordEncoder().encode(request.password());
    var newProgrammer = new Programmer(request.name(), request.email(), encryptedPassword, request.role());

    repository.save(newProgrammer);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  // TESTING
  @GetMapping("/test/get")
  ResponseEntity<List<Programmer>> getProgrammers() {
    List<Programmer> programmers = this.repository.findAll();
    return ResponseEntity.ok(programmers);
  }
}
