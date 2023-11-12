package com.tasklzr.tasklzr.adapters;

import com.tasklzr.tasklzr.core.models.programmer.Programmer;

import java.util.List;

public interface GetProgrammersGateway {
  Programmer getOneProgrammer(Long id) throws Exception;
  List<Programmer> getAllProgrammers();
}
