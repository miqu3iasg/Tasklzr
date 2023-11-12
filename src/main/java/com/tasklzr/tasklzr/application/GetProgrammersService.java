package com.tasklzr.tasklzr.application;

import com.tasklzr.tasklzr.adapters.GetProgrammersGateway;
import com.tasklzr.tasklzr.core.models.programmer.Programmer;
import com.tasklzr.tasklzr.core.useCases.GetProgrammersUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProgrammersService implements GetProgrammersUseCase {
  final GetProgrammersGateway gateway;

  public GetProgrammersService(GetProgrammersGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public Programmer getOneProgrammer(Long id) throws Exception {
    return this.gateway.getOneProgrammer(id);
  }

  @Override
  public List<Programmer> getAllProgrammers() {
    return this.gateway.getAllProgrammers();
  }
}
