package com.tasklzr.tasklzr.infra;

import com.tasklzr.tasklzr.adapters.UpdateTaskGateway;
import com.tasklzr.tasklzr.core.models.Task;
import com.tasklzr.tasklzr.core.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateTaskImpl implements UpdateTaskGateway {
  final TaskRepository repository;

  public UpdateTaskImpl(TaskRepository repository) {
    this.repository = repository;
  }

  @Override
  public void updateTitleTask(UUID id, String title) throws Exception {
    ModelMapper mapper = new ModelMapper();

    Optional<Task> taskExists = repository.findById(id);
    if (taskExists.isEmpty()) throw new Exception("Task not found");

    taskExists.get().setTitle(title);
    taskExists.get().setUpdatedAt(LocalDateTime.now());

    var taskUpdated = taskExists.get();
    mapper.map(taskExists, taskUpdated);

    repository.save(taskUpdated);

  }

  @Override
  public void updateDescriptionTask(UUID id, String description) throws Exception {
    ModelMapper mapper = new ModelMapper();

    Optional<Task> taskExists = repository.findById(id);
    if (taskExists.isEmpty()) throw new Exception("Task not found");

    taskExists.get().setDescription(description);
    taskExists.get().setUpdatedAt(LocalDateTime.now());

    var taskUpdated = taskExists.get();
    mapper.map(taskExists, taskUpdated);

    repository.save(taskUpdated);
  }
}
