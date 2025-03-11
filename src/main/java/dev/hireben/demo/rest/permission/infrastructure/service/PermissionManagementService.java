package dev.hireben.demo.rest.permission.infrastructure.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.hireben.demo.rest.permission.application.dto.CreateAccessRoleDTO;
import dev.hireben.demo.rest.permission.application.dto.CreateApiAccessDTO;
import dev.hireben.demo.rest.permission.application.dto.CreateViewAccessDTO;
import dev.hireben.demo.rest.permission.application.dto.UpdateApiAccessDTO;
import dev.hireben.demo.rest.permission.application.dto.UpdateViewAccessDTO;
import dev.hireben.demo.rest.permission.application.usecase.AssignApiAccessToRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.AssignApiAccessToViewUseCase;
import dev.hireben.demo.rest.permission.application.usecase.AssignViewAccessToRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.CreateAccessRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.CreateApiAccessUseCase;
import dev.hireben.demo.rest.permission.application.usecase.CreateViewAccessUseCase;
import dev.hireben.demo.rest.permission.application.usecase.DeleteAccessRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.DeleteApiAccessUseCase;
import dev.hireben.demo.rest.permission.application.usecase.DeleteViewAccessUseCase;
import dev.hireben.demo.rest.permission.application.usecase.UnassignApiAccessFromRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.UnassignApiAccessFromViewUseCase;
import dev.hireben.demo.rest.permission.application.usecase.UnassignViewAccessFromRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.UpdateApiAccessUseCase;
import dev.hireben.demo.rest.permission.application.usecase.UpdateViewAccessUseCase;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PermissionManagementService {

  // ---------------------------------------------------------------------------//
  // Dependencies
  // ---------------------------------------------------------------------------//

  private final AssignApiAccessToRoleUseCase assignApiAccessToRoleUseCase;
  private final AssignApiAccessToViewUseCase assignApiAccessToViewUseCase;
  private final AssignViewAccessToRoleUseCase assignViewAccessToRoleUseCase;

  private final UnassignApiAccessFromRoleUseCase unassignApiAccessFromRoleUseCase;
  private final UnassignApiAccessFromViewUseCase unassignApiAccessFromViewUseCase;
  private final UnassignViewAccessFromRoleUseCase unassignViewAccessFromRoleUseCase;

  private final CreateAccessRoleUseCase createAccessRoleUseCase;
  private final CreateApiAccessUseCase createApiAccessUseCase;
  private final CreateViewAccessUseCase createViewAccessUseCase;

  private final UpdateApiAccessUseCase updateApiAccessUseCase;
  private final UpdateViewAccessUseCase updateViewAccessUseCase;

  private final DeleteAccessRoleUseCase deleteAccessRoleUseCase;
  private final DeleteApiAccessUseCase deleteApiAccessUseCase;
  private final DeleteViewAccessUseCase deleteViewAccessUseCase;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void assignApiAccessToRole(String roleName, Collection<String> apiNames) {
    assignApiAccessToRoleUseCase.execute(roleName, apiNames);
  }

  // ---------------------------------------------------------------------------//

  public void assignApiAccessToView(String viewName, Collection<String> apiNames) {
    assignApiAccessToViewUseCase.execute(viewName, apiNames);
  }

  // ---------------------------------------------------------------------------//

  public void assignViewAccessToRole(String roleName, Collection<String> viewNames) {
    assignViewAccessToRoleUseCase.execute(roleName, viewNames);
  }

  // ---------------------------------------------------------------------------//

  public void unassignApiAccessFromRole(String roleName, Collection<String> apiNames) {
    unassignApiAccessFromRoleUseCase.execute(roleName, apiNames);
  }

  // ---------------------------------------------------------------------------//

  public void unassignApiAccessFromView(String viewName, Collection<String> apiNames) {
    unassignApiAccessFromViewUseCase.execute(viewName, apiNames);
  }

  // ---------------------------------------------------------------------------//

  public void unassignViewAccessFromRole(String roleName, Collection<String> viewNames) {
    unassignViewAccessFromRoleUseCase.execute(roleName, viewNames);
  }

  // ---------------------------------------------------------------------------//

  public String createAccessRole(CreateAccessRoleDTO dto) {
    return createAccessRoleUseCase.execute(dto);
  }

  // ---------------------------------------------------------------------------//

  public String createApiAccess(CreateApiAccessDTO dto) {
    return createApiAccessUseCase.execute(dto);
  }

  // ---------------------------------------------------------------------------//

  public String createViewAccess(CreateViewAccessDTO dto) {
    return createViewAccessUseCase.execute(dto);
  }

  // ---------------------------------------------------------------------------//

  public void updateApiAccess(String apiName, UpdateApiAccessDTO dto) {
    updateApiAccessUseCase.execute(apiName, dto);
  }

  // ---------------------------------------------------------------------------//

  public void updateViewAccess(String viewName, UpdateViewAccessDTO dto) {
    updateViewAccessUseCase.execute(viewName, dto);
  }

  // ---------------------------------------------------------------------------//

  public void deleteAccessRole(String roleName) {
    deleteAccessRoleUseCase.execute(roleName);
  }

  // ---------------------------------------------------------------------------//

  public void deleteApiAccess(String apiName) {
    deleteApiAccessUseCase.execute(apiName);
  }

  // ---------------------------------------------------------------------------//

  public void deleteViewAccess(String viewName) {
    deleteViewAccessUseCase.execute(viewName);
  }

}
