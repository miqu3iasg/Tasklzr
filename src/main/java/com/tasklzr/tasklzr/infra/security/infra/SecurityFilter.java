package com.tasklzr.tasklzr.infra.security.infra;

import com.tasklzr.tasklzr.core.repositories.ProgrammerRepository;
import com.tasklzr.tasklzr.infra.security.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
  final TokenService tokenService;
  final @Lazy ProgrammerRepository repository;

  public SecurityFilter(TokenService tokenService, ProgrammerRepository repository) {
    this.tokenService = tokenService;
    this.repository = repository;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    var token = this.recoverToken(request);
    if(token != null){
      var subject = tokenService.validateToken(token);
      UserDetails programmer = repository.findByEmail(subject);

      if(programmer != null) {
        var authentication = new UsernamePasswordAuthenticationToken(programmer, null, programmer.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }

    }
    filterChain.doFilter(request, response);

  }
  private String recoverToken(HttpServletRequest request) {
    var authHeader = request.getHeader("Authorization");
    if(authHeader == null) return null;
    return authHeader.replace("Bearer ", "");
  }
}
