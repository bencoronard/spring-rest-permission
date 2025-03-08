package dev.hireben.demo.rest.permission.application.usecase;

import java.util.Collection;
import java.util.Set;

import dev.hireben.demo.rest.permission.application.exception.NonExistentAccessRoleException;
import dev.hireben.demo.rest.permission.domain.entity.AccessRole;
import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
import dev.hireben.demo.rest.permission.domain.repository.AccessRoleRepository;
import dev.hireben.demo.rest.permission.domain.repository.ViewAccessRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AssignViewAccessToRoleUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final AccessRoleRepository rolePermissionRepository;
  private final ViewAccessRepository viewAccessRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void execute(String roleName, Collection<String> viewNames) {

    AccessRole role = rolePermissionRepository.findByName(roleName)
        .orElseThrow(() -> new NonExistentAccessRoleException(String.format("Role %s not found", roleName)));

    Set<ViewAccess> accesses = viewAccessRepository.findByNameIn(viewNames);

    role.getViewAccesses().addAll(accesses);

    rolePermissionRepository.save(role);
  }

}
