package com.tasklzr.tasklzr.infra;

import com.tasklzr.tasklzr.adapters.CreateTaskGateway;
import com.tasklzr.tasklzr.core.models.Task;
import com.tasklzr.tasklzr.core.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskImpl implements CreateTaskGateway {
  final TaskRepository repository;

  public CreateTaskImpl(TaskRepository repository) {
    this.repository = repository;
  }

  @Override
  public Task createTask(String title, String description) throws Exception {
    var taskExists = repository.findTaskByTitle(title);
    if(taskExists.isPresent()) throw new Exception("Task " + title + " already exists");

    var task = new Task(title, description);
    return repository.save(task);
  }
}
