package com.tasklzr.tasklzr.core.useCases;

import com.tasklzr.tasklzr.core.models.Task;

import java.util.UUID;

public interface UpdateTaskUseCase {
  Task updateTitleTask(UUID id, String title) throws Exception;
  Task updateDescriptionTask(UUID id, String description) throws Exception;
}
