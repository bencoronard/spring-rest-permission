package dev.hireben.demo.rest.permission.domain.entity;

import java.util.Optional;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessRole {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final Long id;
  private final String name;
  private final Set<ViewAccess> viewAccesses;
  private final Set<ApiAccess> apiAccesses;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public Optional<ViewAccess> getViewAccess(String viewName) {
    return viewAccesses.stream().filter(view -> view.getName().equals(viewName)).findFirst();
  }

  // ---------------------------------------------------------------------------//

  public boolean hasApiAccess(String apiName) {
    return apiAccesses.stream().anyMatch(permission -> permission.getName().equals(apiName));
  }

}
