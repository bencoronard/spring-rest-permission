package dev.hireben.demo.rest.permission.presentation.dto;

import java.util.Collection;

import jakarta.validation.constraints.NotBlank;

public record CreateApiAccessRequest(
    @NotBlank String apiName,
    @NotBlank String apiToken,
    Collection<String> linkedViewNames) {
}
