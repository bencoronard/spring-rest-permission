package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.application.exception.NonExistentRolePermissionException;
import dev.hireben.demo.rest.permission.application.exception.NonExistentViewAccessException;
import dev.hireben.demo.rest.permission.application.port.RolePermissionRepository;
import dev.hireben.demo.rest.permission.application.port.ViewAccessRepository;
import dev.hireben.demo.rest.permission.domain.entity.RolePermission;
import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AssignViewAccessToRoleUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final RolePermissionRepository roleRepository;
  private final ViewAccessRepository viewPermissionRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void execute(String roleId, String viewId) {

    RolePermission role = roleRepository.findById(roleId)
        .orElseThrow(() -> new NonExistentRolePermissionException(String.format("Role %s not found", roleId)));

    ViewAccess permission = viewPermissionRepository.findById(viewId)
        .orElseThrow(() -> new NonExistentViewAccessException(String.format("View permission %s not found", viewId)));

    role.getViewPermissions().add(permission);

    roleRepository.save(role);
  }

}
