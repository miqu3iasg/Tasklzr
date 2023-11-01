package com.tasklzr.tasklzr.adapters;

import com.tasklzr.tasklzr.core.models.task.Task;

public interface CreateTaskGateway {
  Task createTask(String title, String description) throws Exception;
}
