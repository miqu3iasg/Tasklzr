package com.tasklzr.tasklzr.core.dtos;

import com.tasklzr.tasklzr.core.models.user.UserRole;

public record RegisterUserDTO(String login, String password, UserRole role) {
}
