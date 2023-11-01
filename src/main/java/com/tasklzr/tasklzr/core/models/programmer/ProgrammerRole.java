package com.tasklzr.tasklzr.core.models.programmer;

public enum ProgrammerRole {
  ADMIN("admin"),
  USER("user");

  private String role;

  ProgrammerRole(String role) {
    this.role = role;
  }
  String getRole() {
    return role;
  }
}
