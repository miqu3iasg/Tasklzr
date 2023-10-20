package com.tasklzr.tasklzr.application;

import com.tasklzr.tasklzr.adapters.UpdateTaskGateway;
import com.tasklzr.tasklzr.core.models.Task;
import com.tasklzr.tasklzr.core.repository.TaskRepository;
import com.tasklzr.tasklzr.core.useCases.UpdateTaskUseCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateTaskService implements UpdateTaskUseCase {
  final UpdateTaskGateway gateway;

  public UpdateTaskService(UpdateTaskGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public Task updateTitleTask(UUID id, String title) throws Exception {
    return gateway.updateTitleTask(id, title);
  }

  @Override
  public Task updateDescriptionTask(UUID id, String description) throws Exception {
    return gateway.updateDescriptionTask(id, description);
  }
}
