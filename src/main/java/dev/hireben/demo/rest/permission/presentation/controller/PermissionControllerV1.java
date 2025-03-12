package dev.hireben.demo.rest.permission.presentation.controller;

import java.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hireben.demo.rest.permission.infrastructure.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/permissions")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PermissionControllerV1 {

  // ---------------------------------------------------------------------------//
  // Dependencies
  // ---------------------------------------------------------------------------//

  private final PermissionService permissionService;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  @GetMapping("/roles/{roleName}/apis/{apiName}")
  public ResponseEntity<Void> checkApiPermission(
      @PathVariable String roleName,
      @PathVariable String apiName) {

    permissionService.checkApiAccessByRole(roleName, apiName);

    return ResponseEntity.noContent().build();
  }

  // ---------------------------------------------------------------------------//

  @GetMapping("/roles/{roleName}/views/{viewName}")
  public ResponseEntity<Collection<String>> checkViewPermission(
      @PathVariable String roleName,
      @PathVariable String viewName) {

    return ResponseEntity.ok(permissionService.checkViewAccessByRole(roleName, viewName));
  }

}
