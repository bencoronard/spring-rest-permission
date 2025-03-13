package dev.hireben.demo.rest.permission.presentation.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hireben.demo.rest.permission.application.dto.CreateAccessRoleDTO;
import dev.hireben.demo.rest.permission.application.dto.CreateApiAccessDTO;
import dev.hireben.demo.rest.permission.application.dto.CreateViewAccessDTO;
import dev.hireben.demo.rest.permission.application.dto.UpdateApiAccessDTO;
import dev.hireben.demo.rest.permission.application.dto.UpdateViewAccessDTO;
import dev.hireben.demo.rest.permission.infrastructure.service.PermissionManagementService;
import dev.hireben.demo.rest.permission.presentation.dto.CreateApiAccessRequest;
import dev.hireben.demo.rest.permission.presentation.dto.CreateRoleRequest;
import dev.hireben.demo.rest.permission.presentation.dto.CreateViewAccessRequest;
import dev.hireben.demo.rest.permission.presentation.dto.UpdateApiAccessRequest;
import dev.hireben.demo.rest.permission.presentation.dto.UpdateViewAccessRequest;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
@RequestMapping("/v1/permissions")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PermissionManagementControllerV1 {

  // ---------------------------------------------------------------------------//
  // Dependencies
  // ---------------------------------------------------------------------------//

  private final PermissionManagementService permissionManagementService;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  @PutMapping("/roles/{roleName}/apis/assign")
  public ResponseEntity<Void> assignApiPermissionsToRole(
      @PathVariable String roleName,
      @RequestBody Collection<String> apiNames) {

    permissionManagementService.assignApiAccessToRole(roleName, apiNames);

    return ResponseEntity.noContent().build();
  }

  // ---------------------------------------------------------------------------//

  @PutMapping("/roles/{roleName}/views/assign")
  public ResponseEntity<Void> assignViewPermissionsToRole(
      @PathVariable String roleName,
      @RequestBody Collection<String> viewNames) {

    permissionManagementService.assignViewAccessToRole(roleName, viewNames);

    return ResponseEntity.noContent().build();
  }

  // ---------------------------------------------------------------------------//

  @PutMapping("/views/{viewName}/apis/assign")
  public ResponseEntity<Void> assignApiPermissionsToView(
      @PathVariable String viewName,
      @RequestBody Collection<String> apiNames) {

    permissionManagementService.assignApiAccessToView(viewName, apiNames);

    return ResponseEntity.noContent().build();
  }

  // ---------------------------------------------------------------------------//

  @PutMapping("/roles/{roleName}/apis/unassign")
  public ResponseEntity<Void> unassignApiPermissionsFromRole(
      @PathVariable String roleName,
      @RequestBody Collection<String> apiNames) {

    permissionManagementService.unassignApiAccessFromRole(roleName, apiNames);

    return ResponseEntity.noContent().build();
  }

  // ---------------------------------------------------------------------------//

  @PutMapping("/roles/{roleName}/views/unassign")
  public ResponseEntity<Void> unassignViewPermissionsFromRole(
      @PathVariable String roleName,
      @RequestBody Collection<String> viewNames) {

    permissionManagementService.unassignViewAccessFromRole(roleName, viewNames);

    return ResponseEntity.noContent().build();
  }

  // ---------------------------------------------------------------------------//

  @PutMapping("/views/{viewName}/apis/unassign")
  public ResponseEntity<Void> unassignApiPermissionsFromView(
      @PathVariable String viewName,
      @RequestBody Collection<String> apiNames) {

    permissionManagementService.unassignApiAccessFromView(viewName, apiNames);

    return ResponseEntity.noContent().build();
  }

  // ---------------------------------------------------------------------------//

  @PostMapping("/roles")
  public ResponseEntity<Void> createRole(
      @RequestBody @Valid CreateRoleRequest body) {

    CreateAccessRoleDTO dto = CreateAccessRoleDTO.builder()
        .roleName(body.roleName())
        .apiNames(body.apiNames())
        .viewNames(body.viewNames())
        .build();

    String roleName = permissionManagementService.createAccessRole(dto);

    return ResponseEntity.created(URI.create(roleName)).build();
  }

  // ---------------------------------------------------------------------------//

  @PostMapping("/apis")
  public ResponseEntity<Void> createApiPermission(
      @RequestBody @Valid CreateApiAccessRequest body) {

    CreateApiAccessDTO dto = CreateApiAccessDTO.builder()
        .apiName(body.apiName())
        .apiToken(body.apiToken())
        .linkedViewNames(body.linkedViewNames())
        .build();

    String apiName = permissionManagementService.createApiAccess(dto);

    return ResponseEntity.created(URI.create(apiName)).build();
  }

  // ---------------------------------------------------------------------------//

  @PostMapping("/views")
  public ResponseEntity<Void> createViewPermission(
      @RequestBody @Valid CreateViewAccessRequest body) {

    CreateViewAccessDTO dto = CreateViewAccessDTO.builder()
        .viewName(body.viewName())
        .viewToken(body.viewToken())
        .linkedApiNames(body.linkedApiNames())
        .build();

    String viewName = permissionManagementService.createViewAccess(dto);

    return ResponseEntity.created(URI.create(viewName)).build();
  }

  // ---------------------------------------------------------------------------//

  @PatchMapping("/apis/{apiName}")
  public ResponseEntity<Void> updateApiPermission(
      @PathVariable String apiName,
      @RequestBody @Valid UpdateApiAccessRequest body) {

    UpdateApiAccessDTO dto = UpdateApiAccessDTO.builder()
        .newApiName(body.newApiName())
        .newApiToken(body.newApiToken())
        .build();

    permissionManagementService.updateApiAccess(apiName, dto);

    return ResponseEntity.noContent().build();
  }

  // ---------------------------------------------------------------------------//

  @PatchMapping("/views/{viewName}")
  public ResponseEntity<Void> updateViewPermission(
      @PathVariable String viewName,
      @RequestBody @Valid UpdateViewAccessRequest body) {

    UpdateViewAccessDTO dto = UpdateViewAccessDTO.builder()
        .newViewName(body.newViewName())
        .newViewToken(body.newViewToken())
        .build();

    permissionManagementService.updateViewAccess(viewName, dto);

    return ResponseEntity.noContent().build();
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
