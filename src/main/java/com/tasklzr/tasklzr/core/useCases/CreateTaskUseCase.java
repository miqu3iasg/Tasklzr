package com.tasklzr.tasklzr.core.useCases;

import com.tasklzr.tasklzr.core.models.Task;

public interface CreateTaskUseCase {
  Task createTask(String title, String description) throws Exception;
}
