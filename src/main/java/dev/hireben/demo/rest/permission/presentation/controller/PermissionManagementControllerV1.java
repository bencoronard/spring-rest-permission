package dev.hireben.demo.rest.permission.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hireben.demo.rest.permission.infrastructure.service.PermissionManagementService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/permissions")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@SuppressWarnings("unused")
public class PermissionManagementControllerV1 {

  // ---------------------------------------------------------------------------//
  // Dependencies
  // ---------------------------------------------------------------------------//

  private final PermissionManagementService permissionManagementService;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public ResponseEntity<Void> assignApiPermissionsToRole(
      @PathVariable String roleName) {
    return ResponseEntity.ok().build();
  }

  // ---------------------------------------------------------------------------//

  public ResponseEntity<Void> assignViewPermissionsToRole(
      @PathVariable String roleName) {
    return ResponseEntity.ok().build();
  }

  // ---------------------------------------------------------------------------//

  public ResponseEntity<Void> assignApiPermissionsToView(
      @PathVariable String viewName) {
    return ResponseEntity.ok().build();
  }

  // ---------------------------------------------------------------------------//

  public ResponseEntity<Void> unassignApiPermissionsFromRole(
      @PathVariable String roleName) {
    return ResponseEntity.ok().build();
  }

  // ---------------------------------------------------------------------------//

  public ResponseEntity<Void> unassignViewPermissionsFromRole(
      @PathVariable String roleName) {
    return ResponseEntity.ok().build();
  }

  // ---------------------------------------------------------------------------//

  public ResponseEntity<Void> unassignApiPermissionsFromView(
      @PathVariable String viewName) {
    return ResponseEntity.ok().build();
  }

  // ---------------------------------------------------------------------------//

  public ResponseEntity<Void> createRole(
      @PathVariable String roleName) {
    return ResponseEntity.ok().build();
  }

  // ---------------------------------------------------------------------------//

  public ResponseEntity<Void> createApiPermission(
      @PathVariable String apiName) {
    return ResponseEntity.ok().build();
  }

  // ---------------------------------------------------------------------------//

  public ResponseEntity<Void> createViewPermission(
      @PathVariable String viewName) {
    return ResponseEntity.ok().build();
  }

  // ---------------------------------------------------------------------------//

  public ResponseEntity<Void> updateApiPermission(
      @PathVariable String apiName) {
    return ResponseEntity.ok().build();
  }

  // ---------------------------------------------------------------------------//

  public ResponseEntity<Void> updateViewPermission(
      @PathVariable String viewName) {
    return ResponseEntity.ok().build();
  }

  // ---------------------------------------------------------------------------//

  @DeleteMapping("/roles/{roleName}")
  public ResponseEntity<Void> deleteRole(
      @PathVariable String roleName) {

    permissionManagementService.deleteAccessRole(roleName);

    return ResponseEntity.noContent().build();
  }

  // ---------------------------------------------------------------------------//

  @DeleteMapping("/apis/{apiName}")
  public ResponseEntity<Void> deleteApiPermission(
      @PathVariable String apiName) {

    permissionManagementService.deleteApiAccess(apiName);

    return ResponseEntity.noContent().build();
  }

  // ---------------------------------------------------------------------------//

  @DeleteMapping("/views/{viewName}")
  public ResponseEntity<Void> deleteViewPermission(
      @PathVariable String viewName) {

    permissionManagementService.deleteViewAccess(viewName);

    return ResponseEntity.noContent().build();
  }

}
