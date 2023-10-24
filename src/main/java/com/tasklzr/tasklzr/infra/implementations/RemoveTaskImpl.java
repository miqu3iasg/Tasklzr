package com.tasklzr.tasklzr.infra.implementations;

import com.tasklzr.tasklzr.adapters.RemoveTaskGateway;
import com.tasklzr.tasklzr.core.models.Task;
import com.tasklzr.tasklzr.core.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RemoveTaskImpl implements RemoveTaskGateway {
  final TaskRepository repository;

  public RemoveTaskImpl(TaskRepository repository) {
    this.repository = repository;
  }

  @Override
  public void removeTask(UUID id) throws Exception {
    Optional<Task> taskExists = repository.findById(id);

    if(taskExists.isEmpty()) throw new Exception("Task not found");

    repository.deleteById(id);
  }
}
