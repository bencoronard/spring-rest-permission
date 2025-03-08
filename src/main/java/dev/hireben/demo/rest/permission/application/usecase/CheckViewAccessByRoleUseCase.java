package dev.hireben.demo.rest.permission.application.usecase;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import dev.hireben.demo.rest.permission.application.exception.NonExistentAccessRoleException;
import dev.hireben.demo.rest.permission.application.exception.NonExistentViewAccessException;
import dev.hireben.demo.rest.permission.domain.entity.AccessRole;
import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
import dev.hireben.demo.rest.permission.domain.repository.AccessRoleRepository;
import dev.hireben.demo.rest.permission.domain.repository.ViewAccessRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckViewAccessByRoleUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final AccessRoleRepository accessRoleRepository;
  private final ViewAccessRepository viewAccessRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public Optional<Set<String>> execute(String roleName, String viewName) {

    AccessRole role = accessRoleRepository.findByName(roleName)
        .orElseThrow(() -> new NonExistentAccessRoleException(String.format("Role %s not found", roleName)));

    if (role.hasViewAccess(viewName)) {
      ViewAccess viewAccess = viewAccessRepository.findByName(viewName)
          .orElseThrow(() -> new NonExistentViewAccessException(String.format("View %s not found", viewName)));

      Set<String> apiTokens = viewAccess.getLinkedApis().stream()
          .map(api -> api.getToken())
          .collect(Collectors.toSet());

      return Optional.of(apiTokens);
    }

    return Optional.empty();
  }

}
