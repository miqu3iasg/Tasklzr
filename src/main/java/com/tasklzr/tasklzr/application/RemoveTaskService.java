package com.tasklzr.tasklzr.application;

import com.tasklzr.tasklzr.adapters.RemoveTaskGateway;
import com.tasklzr.tasklzr.core.useCases.RemoveTaskUseCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RemoveTaskService implements RemoveTaskUseCase {
  final RemoveTaskGateway gateway;

  public RemoveTaskService(RemoveTaskGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public void removeTask(UUID id) throws Exception {
    gateway.removeTask(id);
  }
}
