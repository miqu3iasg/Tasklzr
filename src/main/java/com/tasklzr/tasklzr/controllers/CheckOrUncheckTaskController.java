package com.tasklzr.tasklzr.controllers;

import com.tasklzr.tasklzr.application.CheckOrUncheckTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CheckOrUncheckTaskController {
  final CheckOrUncheckTaskService service;

  public CheckOrUncheckTaskController(CheckOrUncheckTaskService service) {
    this.service = service;
  }

  @PatchMapping
  @RequestMapping("checkTask/{id}")
  public ResponseEntity<String> checkTask(@PathVariable(name = "id") UUID id) throws Exception {
    try {
      service.checkTask(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new Exception("checking task failed");
    }
  }

  @PatchMapping
  @RequestMapping("uncheckTask/{id}")
  public ResponseEntity<String> uncheckTask(@PathVariable(name = "id")UUID id) throws Exception {
    try {
      service.uncheckTask(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new Exception("unchecking task failed");
    }
  }
}
