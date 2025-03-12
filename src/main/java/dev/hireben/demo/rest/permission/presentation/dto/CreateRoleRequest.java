package dev.hireben.demo.rest.permission.presentation.dto;

import java.util.Collection;

import jakarta.validation.constraints.NotBlank;

public record CreateRoleRequest(
    @NotBlank String roleName,
    Collection<String> viewNames,
    Collection<String> apiNames) {
}
