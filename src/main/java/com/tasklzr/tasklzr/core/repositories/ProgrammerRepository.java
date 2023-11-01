package com.tasklzr.tasklzr.core.repositories;

import com.tasklzr.tasklzr.core.models.programmer.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {
  UserDetails findByEmail(String email);
}
