package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.application.exception.NonExistentAccessRoleException;

import java.util.Collection;
import java.util.Set;

import dev.hireben.demo.rest.permission.domain.entity.AccessRole;
import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import dev.hireben.demo.rest.permission.domain.repository.AccessRoleRepository;
import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AssignApiAccessToRoleUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final AccessRoleRepository rolePermissionRepository;
  private final ApiAccessRepository apiAccessRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void execute(String roleName, Collection<String> apiNames) {

    AccessRole role = rolePermissionRepository.findByName(roleName)
        .orElseThrow(() -> new NonExistentAccessRoleException(String.format("Role %s not found", roleName)));

    Set<ApiAccess> accesses = apiAccessRepository.findByNameIn(apiNames);

    role.getApiAccesses().addAll(accesses);

    rolePermissionRepository.save(role);
  }

}
