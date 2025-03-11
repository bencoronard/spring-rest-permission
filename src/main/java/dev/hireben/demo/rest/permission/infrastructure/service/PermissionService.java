package dev.hireben.demo.rest.permission.infrastructure.service;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.hireben.demo.rest.permission.application.usecase.CheckApiAccessByRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.CheckViewAccessByRoleUseCase;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PermissionService {

  // ---------------------------------------------------------------------------//
  // Dependencies
  // ---------------------------------------------------------------------------//

  private final CheckApiAccessByRoleUseCase checkApiAccessByRoleUseCase;
  private final CheckViewAccessByRoleUseCase checkViewAccessByRoleUseCase;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public boolean checkApiAccessByRole(String roleName, String apiName) {
    return checkApiAccessByRoleUseCase.execute(roleName, apiName);
  }

  // ---------------------------------------------------------------------------//

  public Set<String> checkViewAccessByRole(String roleName, String viewName) {
    return checkViewAccessByRoleUseCase.execute(roleName, viewName).orElseGet(() -> Set.of());
  }

}
