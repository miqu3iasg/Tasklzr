package com.tasklzr.tasklzr.adapters;

import com.tasklzr.tasklzr.dtos.CreateTaskDTO;
import com.tasklzr.tasklzr.models.Task;

public interface CreateTaskGateway {
  Task createTask(String title, String description) throws Exception;
}
