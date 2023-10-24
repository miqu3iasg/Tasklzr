package com.tasklzr.tasklzr.infra.implementations;

import com.tasklzr.tasklzr.adapters.UpdateTaskGateway;
import com.tasklzr.tasklzr.core.models.Task;
import com.tasklzr.tasklzr.core.repositories.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateTaskImpl implements UpdateTaskGateway {
  String regEx = "[{\\r\\n|\\r|\\n|\"|:}]+", replacement = "";
  final TaskRepository repository;
  public UpdateTaskImpl(TaskRepository repository) {
    this.repository = repository;
  }

  @Override
  public Task updateTitleTask(UUID id, String title) throws Exception {
    ModelMapper mapper = new ModelMapper();

    Optional<Task> taskExists = repository.findById(id);
    if (taskExists.isEmpty()) throw new Exception("Task not found");

    taskExists.get().setTitle(title
            .replaceAll(regEx, replacement)
            .replace("title", replacement)
            .trim());

    taskExists.get().setUpdatedAt(LocalDateTime.now());

    var taskUpdated = taskExists.get();
    mapper.map(taskExists, taskUpdated);

    return repository.save(taskUpdated);

  }

  @Override
  public Task updateDescriptionTask(UUID id, String description) throws Exception {
    ModelMapper mapper = new ModelMapper();

    Optional<Task> taskExists = repository.findById(id);
    if (taskExists.isEmpty()) throw new Exception("Task not found");

    taskExists.get().setDescription(description
            .replaceAll(regEx, replacement)
            .replace("description", replacement)
            .trim());

    taskExists.get().setUpdatedAt(LocalDateTime.now());

    var taskUpdated = taskExists.get();
    mapper.map(taskExists, taskUpdated);

    return repository.save(taskUpdated);
  }
}
