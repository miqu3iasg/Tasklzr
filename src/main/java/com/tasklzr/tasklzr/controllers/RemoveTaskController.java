package com.tasklzr.tasklzr.controllers;

import com.tasklzr.tasklzr.application.RemoveTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("remove/{id}")
public class RemoveTaskController {
  final RemoveTaskService service;

  public RemoveTaskController(RemoveTaskService service) {
    this.service = service;
  }

  @DeleteMapping
  public ResponseEntity<String> removeTask(@PathVariable(name = "id") UUID id) throws Exception {
    try {
      service.removeTask(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new Exception("Error removing task");
    }
  }
}
