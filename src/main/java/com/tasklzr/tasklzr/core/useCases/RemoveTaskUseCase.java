package com.tasklzr.tasklzr.core.useCases;

import java.util.UUID;

public interface RemoveTaskUseCase {
  void removeTask(UUID id) throws Exception;
}
