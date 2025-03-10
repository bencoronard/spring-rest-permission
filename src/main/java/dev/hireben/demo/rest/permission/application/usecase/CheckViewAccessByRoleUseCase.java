package dev.hireben.demo.rest.permission.application.usecase;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import dev.hireben.demo.rest.permission.application.exception.NonExistentAccessRoleException;
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

  public Optional<Set<String>> execute(String roleName, String viewName) {

    AccessRole role = accessRoleRepository.findByName(roleName)
        .orElseThrow(() -> new NonExistentAccessRoleException(String.format("Role %s not found", roleName)));

    Set<ApiAccess> allowedApis = role.getApiAccesses();

    return role.getViewAccess(viewName)
        .map(view -> view.getLinkedApis().stream()
            .filter(api -> allowedApis.contains(api))
            .map(api -> api.getToken())
            .collect(Collectors.toSet()));
  }

}
