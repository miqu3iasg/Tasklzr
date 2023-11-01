package com.tasklzr.tasklzr.core.useCases;

import com.tasklzr.tasklzr.core.models.task.Task;

public interface CreateTaskUseCase {
  Task createTask(String title, String description) throws Exception;
}
