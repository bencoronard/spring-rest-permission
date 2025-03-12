package dev.hireben.demo.rest.permission.presentation.dto;

public record UpdateViewAccessRequest(
    String newViewName,
    String newViewToken) {
}
