package com.tasklzr.tasklzr.application;

import com.tasklzr.tasklzr.adapters.UpdateTaskGateway;
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
  public void updateTitleTask(UUID id, String title) throws Exception {
    gateway.updateTitleTask(id, title);
  }

  @Override
  public void updateDescriptionTask(UUID id, String description) throws Exception {
    gateway.updateDescriptionTask(id, description);
  }
}
