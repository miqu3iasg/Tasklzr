package com.tasklzr.tasklzr.security.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class SecurityConfiguration {
  final SecurityFilter securityFilter;
  final MvcRequestMatcher.Builder mvc;

  @Lazy
  public SecurityConfiguration(SecurityFilter securityFilter, MvcRequestMatcher.Builder mvc) {
    this.securityFilter = securityFilter;
    this.mvc = mvc;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                    .requestMatchers(HttpMethod.POST, "/register").permitAll() // Only test
                    .requestMatchers(HttpMethod.POST, "/create").hasRole("user")
                    .requestMatchers(HttpMethod.PATCH, "/checkTask/{id}").hasRole("user")
                    .requestMatchers(HttpMethod.PATCH, "/uncheckTask/{id}").hasRole("user")
                    .requestMatchers(HttpMethod.GET, "/getTasks").hasRole("user")
                    .requestMatchers(HttpMethod.GET, "/getTask/{id}").hasRole("user")
                    .requestMatchers(HttpMethod.DELETE, "/remove/{id}").hasRole("user")
                    .requestMatchers(HttpMethod.PUT, "/updateTitle/{id}").hasRole("user")
                    .requestMatchers(HttpMethod.PUT, "/updateDescription/{id}").hasRole("user")
                    .anyRequest().authenticated()
            )
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
    return new MvcRequestMatcher.Builder(introspector);
  }
}
