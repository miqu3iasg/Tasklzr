package com.tasklzr.tasklzr.core.repository;

import com.tasklzr.tasklzr.core.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  UserDetails findByLogin(String login);
}
