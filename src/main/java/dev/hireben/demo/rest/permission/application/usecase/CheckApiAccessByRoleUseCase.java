package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.application.exception.NonExistentAccessRoleException;
import dev.hireben.demo.rest.permission.application.exception.PermissionNotFoundException;
import dev.hireben.demo.rest.permission.domain.entity.AccessRole;
import dev.hireben.demo.rest.permission.domain.repository.AccessRoleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckApiAccessByRoleUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final AccessRoleRepository accessRoleRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void execute(String roleName, String apiName) {

    AccessRole role = accessRoleRepository.findByName(roleName)
        .orElseThrow(() -> new NonExistentAccessRoleException(String.format("Role %s not found", roleName)));

    if (!role.hasApiAccess(apiName)) {
      throw new PermissionNotFoundException(String.format("Role %s does not have access to API %s", roleName, apiName));
    }
  }

}
