package com.tasklzr.tasklzr.infra.implementations;

import com.tasklzr.tasklzr.adapters.CheckOrUncheckTaskGateway;
import com.tasklzr.tasklzr.core.models.task.Task;
import com.tasklzr.tasklzr.core.models.task.TaskStatus;
import com.tasklzr.tasklzr.core.repositories.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class CheckOrUncheckTaskImpl implements CheckOrUncheckTaskGateway {
  final TaskRepository repository;

  public CheckOrUncheckTaskImpl(TaskRepository repository) {
    this.repository = repository;
  }

  @Override
  public void checkTask(UUID id) throws Exception {
    var mapper = new ModelMapper();

    Optional<Task> taskExists = repository.findById(id);
    if(taskExists.isEmpty()) throw new Exception("Task not found");

    taskExists.get().setStatus(TaskStatus.FINISHED);
    taskExists.get().setUpdatedAt(LocalDateTime.now());

    var taskChecked = taskExists.get();
    mapper.map(taskExists, taskChecked);

    repository.save(taskChecked);
  }

  @Override
  public void uncheckTask(UUID id) throws Exception {
    var mapper = new ModelMapper();

    Optional<Task> taskExists = repository.findById(id);
    if(taskExists.isEmpty()) throw new Exception("Task not found");

    taskExists.get().setStatus(TaskStatus.PENDING);
    taskExists.get().setUpdatedAt(LocalDateTime.now());

    var taskChecked = taskExists.get();
    mapper.map(taskExists, taskChecked);

    repository.save(taskChecked);
  }
}
