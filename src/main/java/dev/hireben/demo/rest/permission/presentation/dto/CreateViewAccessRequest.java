package dev.hireben.demo.rest.permission.presentation.dto;

import java.util.Collection;

import jakarta.validation.constraints.NotBlank;

public record CreateViewAccessRequest(
    @NotBlank String viewName,
    @NotBlank String viewToken,
    Collection<String> linkedApiNames) {
}
