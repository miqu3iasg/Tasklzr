package com.tasklzr.tasklzr.controllers;

import com.tasklzr.tasklzr.application.GetTasksService;
import com.tasklzr.tasklzr.models.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class GetTasksController {
  final GetTasksService service;

  public GetTasksController(GetTasksService service) {
    this.service = service;
  }

  @RequestMapping("getTasks")
  @GetMapping
  public ResponseEntity<List<Task>> getTasks() throws Exception {
    try {
      List<Task> tasks = service.getTasks();
      return ResponseEntity.ok().body(tasks);
    } catch (Exception e) {
      throw new Exception("Tasks not found.");
    }
  }

  @RequestMapping("getTask/{id}")
  @GetMapping
  public ResponseEntity<Optional<Task>> getOneTask(@PathVariable(name = "id") UUID id) throws Exception {
    try {
      Optional<Task> task = service.getOneTask(id);
      return ResponseEntity.ok().body(task);
    } catch (Exception e) {
      throw new Exception("Task not found.");
    }
  }
}
