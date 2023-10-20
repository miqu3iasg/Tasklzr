package com.tasklzr.tasklzr.infra;

import com.tasklzr.tasklzr.adapters.GetTasksGateway;
import com.tasklzr.tasklzr.core.models.Task;
import com.tasklzr.tasklzr.core.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GetTasksImpl implements GetTasksGateway {
  final TaskRepository repository;

  public GetTasksImpl(TaskRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Task> getTasks() {
    return repository.findAll();
  }

  @Override
  public Optional<Task> getOneTask(UUID id) throws Exception {
    var taskExists =  repository.findById(id);
    if(taskExists.isEmpty()) throw new Exception("Task not exists in database");

    return taskExists;
  }
}
