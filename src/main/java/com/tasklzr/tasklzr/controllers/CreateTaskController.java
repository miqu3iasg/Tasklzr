package com.tasklzr.tasklzr.controllers;

import com.tasklzr.tasklzr.application.CreateTaskService;
import com.tasklzr.tasklzr.core.dtos.CreateTaskDTO;
import com.tasklzr.tasklzr.core.models.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("create")
public class CreateTaskController {
  final CreateTaskService service;

  public CreateTaskController(CreateTaskService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Task> createTask(@RequestBody CreateTaskDTO request) throws Exception {
    try {
      Task task = service.createTask(request.title(), request.description());
      return  ResponseEntity.ok().body(task);
    } catch (Exception e) {
      throw new Exception("Error creating task");
    }
  }
}
