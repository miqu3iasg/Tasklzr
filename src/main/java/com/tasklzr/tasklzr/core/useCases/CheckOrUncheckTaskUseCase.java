package com.tasklzr.tasklzr.core.useCases;

import java.util.UUID;

public interface CheckOrUncheckTaskUseCase {
  void checkTask(UUID id) throws Exception;
  void uncheckTask(UUID id) throws Exception;
}
