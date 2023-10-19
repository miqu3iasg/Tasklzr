package com.tasklzr.tasklzr.application;

import com.tasklzr.tasklzr.adapters.CreateTaskGateway;
import com.tasklzr.tasklzr.core.useCases.CreateTaskUseCase;
import com.tasklzr.tasklzr.models.Task;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskService implements CreateTaskUseCase {
  final CreateTaskGateway gateway;

  public CreateTaskService(CreateTaskGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public Task createTask(String title, String description) throws Exception {
    return gateway.createTask(title, description);
  }
}
