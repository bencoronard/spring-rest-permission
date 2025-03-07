package dev.hireben.demo.rest.permission.domain.entity;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolePermission {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final String id;
  private final Set<ViewAccess> viewPermissions;
  private final Set<ApiAccess> apiPermissions;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public boolean hasViewPermission(String viewId) {
    return viewPermissions.stream().anyMatch(permission -> permission.getId().equals(viewId));
  }

  // ---------------------------------------------------------------------------//

  public boolean hasApiPermission(String apiId) {
    return apiPermissions.stream().anyMatch(permission -> permission.getId().equals(apiId));
  }

}
