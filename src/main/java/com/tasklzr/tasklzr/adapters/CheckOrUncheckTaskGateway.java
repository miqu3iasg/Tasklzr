package com.tasklzr.tasklzr.adapters;

import java.util.UUID;

public interface CheckOrUncheckTaskGateway {
  void checkTask(UUID id) throws Exception;
  void uncheckTask(UUID id) throws Exception;
}
