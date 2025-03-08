package dev.hireben.demo.rest.permission.domain.entity;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessRole {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final String name;
  private final Set<ViewAccess> viewAccesses;
  private final Set<ApiAccess> apiAccesses;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public boolean hasViewAccess(String viewName) {
    return viewAccesses.stream().anyMatch(permission -> permission.getName().equals(viewName));
  }

  // ---------------------------------------------------------------------------//

  public boolean hasApiAccess(String apiName) {
    return apiAccesses.stream().anyMatch(permission -> permission.getName().equals(apiName));
  }

}
