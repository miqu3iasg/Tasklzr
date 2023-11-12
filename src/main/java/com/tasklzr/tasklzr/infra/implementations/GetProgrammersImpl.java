package com.tasklzr.tasklzr.infra.implementations;

import com.tasklzr.tasklzr.adapters.GetProgrammersGateway;
import com.tasklzr.tasklzr.core.models.programmer.Programmer;
import com.tasklzr.tasklzr.core.repositories.ProgrammerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProgrammersImpl implements GetProgrammersGateway {
  final ProgrammerRepository repository;

  public GetProgrammersImpl(ProgrammerRepository repository) {
    this.repository = repository;
  }

  @Override
  public Programmer getOneProgrammer(Long id) throws Exception {
    return repository.findById(id)
            .orElseThrow(() -> new Exception("Programmer not exists."));
  }

  @Override
  public List<Programmer> getAllProgrammers() {
    return repository.findAll();
  }
}
