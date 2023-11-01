package com.tasklzr.tasklzr.controllers;

import com.tasklzr.tasklzr.application.UpdateTaskService;
import com.tasklzr.tasklzr.core.models.task.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UpdateTaskController {
  final UpdateTaskService service;

  public UpdateTaskController(UpdateTaskService service) {
    this.service = service;
  }

  @PutMapping
  @RequestMapping("updateTitle/{id}")
  public ResponseEntity<Task> updateTitleTask(@PathVariable(name = "id") UUID id, @RequestBody String title) throws Exception {
    try {
      Task task = service.updateTitleTask(id, title);
      return ResponseEntity.ok(task);
    } catch (Exception e) {
      throw new Exception("Error updating title of task");
    }
  }

  @PutMapping
  @RequestMapping("updateDescription/{id}")
  public ResponseEntity<Task> updateDescriptionTask(@PathVariable(name = "id") UUID id, @RequestBody String description) throws Exception {
    try {
      Task task = service.updateDescriptionTask(id, description);
      return ResponseEntity.ok(task);
    } catch (Exception e) {
      throw new Exception("Error updating description of task");
    }
  }
}
