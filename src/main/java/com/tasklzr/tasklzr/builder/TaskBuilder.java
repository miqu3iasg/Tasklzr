package com.tasklzr.tasklzr.builder;

import com.tasklzr.tasklzr.dtos.CreateTaskDTO;
import com.tasklzr.tasklzr.models.Task;
import com.tasklzr.tasklzr.models.TaskStatus;

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
