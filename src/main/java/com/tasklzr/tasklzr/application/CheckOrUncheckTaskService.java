package com.tasklzr.tasklzr.application;

import com.tasklzr.tasklzr.adapters.CheckOrUncheckTaskGateway;
import com.tasklzr.tasklzr.core.useCases.CheckOrUncheckTaskUseCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CheckOrUncheckTaskService implements CheckOrUncheckTaskUseCase {
  final CheckOrUncheckTaskGateway gateway;

  public CheckOrUncheckTaskService(CheckOrUncheckTaskGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public void checkTask(UUID id) throws Exception {
    gateway.checkTask(id);
  }

  @Override
  public void uncheckTask(UUID id) throws Exception {
  gateway.uncheckTask(id);
  }
}
