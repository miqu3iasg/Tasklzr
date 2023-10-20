package com.tasklzr.tasklzr.adapters;

import com.tasklzr.tasklzr.core.models.Task;

import java.util.UUID;

public interface UpdateTaskGateway {
  Task updateTitleTask(UUID id, String title) throws Exception;
  Task updateDescriptionTask(UUID id, String description) throws Exception;
}
