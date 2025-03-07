package dev.hireben.demo.rest.permission.application.usecase;

import java.util.Set;

import dev.hireben.demo.rest.permission.application.dto.CreateRolePermissionDTO;
import dev.hireben.demo.rest.permission.application.exception.DuplicateRolePermissionException;
import dev.hireben.demo.rest.permission.domain.entity.RolePermission;
import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import dev.hireben.demo.rest.permission.domain.repository.RolePermissionRepository;
import dev.hireben.demo.rest.permission.domain.repository.ViewAccessRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateRolePermissionUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final RolePermissionRepository rolePermissionRepository;
  private final ViewAccessRepository viewAccessRepository;
  private final ApiAccessRepository apiAccessRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public String execute(CreateRolePermissionDTO dto) {

    if (rolePermissionRepository.existsById(dto.getRoleId())) {
      throw new DuplicateRolePermissionException(String.format("Role %s already exists", dto.getRoleId()));
    }

    Set<ViewAccess> viewPermissions = viewAccessRepository.findByIds(dto.getViewIds());
    Set<ApiAccess> apiPermissions = apiAccessRepository.findByIds(dto.getApiIds());

    RolePermission newRole = RolePermission.builder()
        .id(dto.getRoleId())
        .viewPermissions(viewPermissions)
        .apiPermissions(apiPermissions)
        .build();

    return rolePermissionRepository.save(newRole);
  }

}
