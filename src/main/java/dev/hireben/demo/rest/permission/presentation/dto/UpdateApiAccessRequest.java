package dev.hireben.demo.rest.permission.presentation.dto;

public record UpdateApiAccessRequest(
    String newApiName,
    String newApiToken) {
}
