package com.tasklzr.tasklzr.core.repositories;

import com.tasklzr.tasklzr.core.models.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
  Optional<Task> findTaskByTitle(String name);
}
