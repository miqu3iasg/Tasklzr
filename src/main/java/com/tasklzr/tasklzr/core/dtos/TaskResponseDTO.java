package com.tasklzr.tasklzr.core.dtos;

import com.tasklzr.tasklzr.core.models.Task;

import java.util.ArrayList;
import java.util.List;

public interface TaskResponseDTO {
  List<Task> tasks = new ArrayList<>();
}
