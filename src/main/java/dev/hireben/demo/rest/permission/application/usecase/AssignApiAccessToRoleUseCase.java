package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.application.exception.NonExistentRolePermissionException;
import dev.hireben.demo.rest.permission.application.exception.NonExistentApiAccessException;
import dev.hireben.demo.rest.permission.domain.entity.RolePermission;
import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import dev.hireben.demo.rest.permission.domain.repository.RolePermissionRepository;
import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AssignApiAccessToRoleUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final RolePermissionRepository rolePermissionRepository;
  private final ApiAccessRepository apiAccessRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void execute(String roleId, String apiId) {

    RolePermission role = rolePermissionRepository.findById(roleId)
        .orElseThrow(() -> new NonExistentRolePermissionException(String.format("Role %s not found", roleId)));

    ApiAccess permission = apiAccessRepository.findById(apiId)
        .orElseThrow(() -> new NonExistentApiAccessException(String.format("API permission %s not found", apiId)));

    role.getApiPermissions().add(permission);

    rolePermissionRepository.save(role);
  }

}
