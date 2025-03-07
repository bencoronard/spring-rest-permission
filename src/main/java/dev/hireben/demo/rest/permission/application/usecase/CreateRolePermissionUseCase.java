package dev.hireben.demo.rest.permission.application.usecase;

import java.util.Set;

import dev.hireben.demo.rest.permission.application.exception.DuplicateRolePermissionException;
import dev.hireben.demo.rest.permission.application.port.RolePermissionRepository;
import dev.hireben.demo.rest.permission.application.port.ApiAccessRepository;
import dev.hireben.demo.rest.permission.application.port.ViewAccessRepository;
import dev.hireben.demo.rest.permission.domain.entity.RolePermission;
import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateRolePermissionUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final RolePermissionRepository roleRepository;
  private final ViewAccessRepository viewPermissionRepository;
  private final ApiAccessRepository apiPermissionRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public String execute(String roleId, Set<String> viewPermissionIds, Set<String> apiPermissionIds) {

    if (roleRepository.existsById(roleId)) {
      throw new DuplicateRolePermissionException(String.format("Role %s already exists", roleId));
    }

    Set<ViewAccess> viewPermissions = viewPermissionRepository.findByIds(viewPermissionIds);
    Set<ApiAccess> apiPermissions = apiPermissionRepository.findByIds(apiPermissionIds);

    RolePermission newRole = RolePermission.builder()
        .id(roleId)
        .viewPermissions(viewPermissions)
        .apiPermissions(apiPermissions)
        .build();

    return roleRepository.save(newRole);
  }

}
