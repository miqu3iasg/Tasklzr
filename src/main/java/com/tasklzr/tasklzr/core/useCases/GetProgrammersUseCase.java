package com.tasklzr.tasklzr.core.useCases;

import com.tasklzr.tasklzr.core.models.programmer.Programmer;

import java.util.List;

public interface GetProgrammersUseCase {
  Programmer getOneProgrammer(Long id) throws Exception;
  List<Programmer> getAllProgrammers();
}
