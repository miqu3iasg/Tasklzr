package com.tasklzr.tasklzr.core.useCases;

import java.util.UUID;

public interface UpdateTaskUseCase {
  void updateTitleTask(UUID id, String title);
  void updateDescriptionTask(UUID id, String description);
}
