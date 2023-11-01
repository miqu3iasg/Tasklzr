package com.tasklzr.tasklzr.infra.security.service;

import com.tasklzr.tasklzr.core.repositories.ProgrammerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {
  final ProgrammerRepository repository;

  AuthorizationService(ProgrammerRepository repository) {
    this.repository = repository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserDetails programmer = repository.findByEmail(username);
    if (programmer == null) {
      throw new UsernameNotFoundException("Usuário não encontrado: " + username);
    }
    return programmer;
  }
}
