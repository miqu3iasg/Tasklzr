package com.tasklzr.tasklzr.core.repository;

import com.tasklzr.tasklzr.core.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
  Optional<Task> findTaskByTitle(String name);
}
