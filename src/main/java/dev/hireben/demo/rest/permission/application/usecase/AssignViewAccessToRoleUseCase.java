package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.application.exception.RolePermissionNotFoundException;
import dev.hireben.demo.rest.permission.application.exception.ViewAccessNotFoundException;
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
        .orElseThrow(() -> new RolePermissionNotFoundException("Role not found"));

    ViewAccess permission = viewPermissionRepository.findById(viewId)
        .orElseThrow(() -> new ViewAccessNotFoundException("View permission not found"));

    role.getViewPermissions().add(permission);

    roleRepository.save(role);
  }

}
