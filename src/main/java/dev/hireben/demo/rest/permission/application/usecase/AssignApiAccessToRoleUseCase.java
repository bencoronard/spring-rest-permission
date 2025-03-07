package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.application.exception.NonExistentRolePermissionException;
import dev.hireben.demo.rest.permission.application.exception.NonExistentApiAccessException;
import dev.hireben.demo.rest.permission.application.port.RolePermissionRepository;
import dev.hireben.demo.rest.permission.application.port.ApiAccessRepository;
import dev.hireben.demo.rest.permission.domain.entity.RolePermission;
import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AssignApiAccessToRoleUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final RolePermissionRepository roleRepository;
  private final ApiAccessRepository apiPermissionRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void execute(String roleId, String apiId) {

    RolePermission role = roleRepository.findById(roleId)
        .orElseThrow(() -> new NonExistentRolePermissionException("Role not found"));

    ApiAccess permission = apiPermissionRepository.findById(apiId)
        .orElseThrow(() -> new NonExistentApiAccessException("API permission not found"));

    role.getApiPermissions().add(permission);

    roleRepository.save(role);
  }

}
