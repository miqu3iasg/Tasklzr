package com.tasklzr.tasklzr.core.dtos;

import com.tasklzr.tasklzr.core.models.programmer.ProgrammerRole;

public record RegisterUserDTO(String name, String email, String password, ProgrammerRole role) {
}
