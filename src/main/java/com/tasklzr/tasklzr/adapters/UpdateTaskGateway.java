package com.tasklzr.tasklzr.adapters;

import java.util.UUID;

public interface UpdateTaskGateway {
  void updateTitleTask(UUID id, String title) throws Exception;
  void updateDescriptionTask(UUID id, String description) throws Exception;
}
