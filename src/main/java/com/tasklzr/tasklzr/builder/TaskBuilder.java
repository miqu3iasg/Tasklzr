package com.tasklzr.tasklzr.builder;

import com.tasklzr.tasklzr.core.dtos.CreateTaskDTO;
import com.tasklzr.tasklzr.core.models.Task;
import com.tasklzr.tasklzr.core.models.TaskStatus;

import java.time.LocalDateTime;

public class TaskBuilder {
  public Task build(CreateTaskDTO instance) {
    var task = new Task();

    task.setTitle(instance.title());
    task.setDescription(instance.description());
    task.setCreatedAt(LocalDateTime.now());
    task.setStatus(TaskStatus.PENDING);

    return task;

  }
}
