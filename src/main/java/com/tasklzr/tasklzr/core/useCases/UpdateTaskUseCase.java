package com.tasklzr.tasklzr.core.useCases;

import java.util.UUID;

public interface UpdateTaskUseCase {
  void updateTitleTask(UUID id, String title) throws Exception;
  void updateDescriptionTask(UUID id, String description) throws Exception;
}
