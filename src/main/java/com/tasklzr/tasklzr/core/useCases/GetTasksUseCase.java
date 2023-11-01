package com.tasklzr.tasklzr.core.useCases;

import com.tasklzr.tasklzr.core.models.task.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GetTasksUseCase {
  List<Task> getTasks();
  Optional<Task> getOneTask(UUID id) throws Exception;
}
