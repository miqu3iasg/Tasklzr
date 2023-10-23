package com.tasklzr.tasklzr.core.models.user;

public enum UserRole {
  ADMIN("admin"),
  USER("user");

  private String role;

  UserRole(String role) {
    this.role = role;
  }
  String getRole() {
    return role;
  }
}
