package dev.hireben.demo.rest.permission.application.usecase;

import java.util.Collection;

import dev.hireben.demo.rest.permission.domain.repository.AccessPermissionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RetrieveAccessPermissionUseCase {

  // ---------------------------------------------------------------------------//
  // Dependencies
  // ---------------------------------------------------------------------------//

  private AccessPermissionRepository repository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public Collection<String> views(String roleId) {
    return repository.findDistinctViewIdByRoleId(roleId);
  }

  // ---------------------------------------------------------------------------//

  public Collection<String> subviews(String roleId, String viewId) {
    return repository.findApiIdByRoleIdAndViewId(roleId, roleId);
  }

  // ---------------------------------------------------------------------------//

  public boolean apiAccess(String roleId, String apiId) {
    return repository.existsByRoleIdAndApiId(roleId, apiId);
  }

}
