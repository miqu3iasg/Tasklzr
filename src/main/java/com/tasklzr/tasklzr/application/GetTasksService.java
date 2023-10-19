package com.tasklzr.tasklzr.application;

import com.tasklzr.tasklzr.adapters.GetTasksGateway;
import com.tasklzr.tasklzr.core.useCases.GetTasksUseCase;
import com.tasklzr.tasklzr.models.Task;
import com.tasklzr.tasklzr.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GetTasksService implements GetTasksUseCase {
  final GetTasksGateway gateway;

  public GetTasksService(GetTasksGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public List<Task> getTasks() {
    return gateway.getTasks();
  }

  @Override
  public Optional<Task> getOneTask(UUID id) throws Exception {
    return gateway.getOneTask(id);
  }
}
