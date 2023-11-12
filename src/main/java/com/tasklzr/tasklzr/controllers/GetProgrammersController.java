package com.tasklzr.tasklzr.controllers;

import com.tasklzr.tasklzr.application.GetProgrammersService;
import com.tasklzr.tasklzr.core.models.programmer.Programmer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("programmers")
public class GetProgrammersController {
  final GetProgrammersService getProgrammersService;

  public GetProgrammersController(GetProgrammersService getProgrammersService) {
    this.getProgrammersService = getProgrammersService;
  }

  @GetMapping("/get-one-programmer/{id}")
  ResponseEntity getOneProgrammer(@PathVariable("id") Long id) {
    try {
      var programmer = getProgrammersService.getOneProgrammer(id);
      return ResponseEntity.ok(programmer);

    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/get-all-programmer/{id}")
  ResponseEntity<List<Programmer>> getAllProgrammers() {
    try {
      var programmer = getProgrammersService.getAllProgrammers();
      return ResponseEntity.ok(programmer);

    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
