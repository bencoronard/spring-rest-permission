package dev.hireben.demo.rest.permission.application.usecase;

import java.util.Set;
import java.util.stream.Collectors;

import dev.hireben.demo.rest.permission.application.exception.NonExistentAccessRoleException;
import dev.hireben.demo.rest.permission.application.exception.PermissionNotFoundException;
import dev.hireben.demo.rest.permission.domain.entity.AccessRole;
import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import dev.hireben.demo.rest.permission.domain.repository.AccessRoleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckViewAccessByRoleUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final AccessRoleRepository accessRoleRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public Set<String> execute(String roleName, String viewName) {

    AccessRole role = accessRoleRepository.findByName(roleName)
        .orElseThrow(() -> new NonExistentAccessRoleException(String.format("Role %s not found", roleName)));

    Set<ApiAccess> allowedApis = role.getApiAccesses();

    return role.getViewAccess(viewName)
        .map(view -> view.getLinkedApis().stream()
            .filter(allowedApis::contains)
            .map(ApiAccess::getToken)
            .collect(Collectors.toSet()))
        .orElseThrow(() -> new PermissionNotFoundException(
            String.format("Role %s does not have access to view %s", roleName, viewName)));
  }

}
