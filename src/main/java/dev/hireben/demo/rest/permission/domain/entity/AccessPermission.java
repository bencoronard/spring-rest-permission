package dev.hireben.demo.rest.permission.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessPermission {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final String roleId;
  private final String viewId;
  private final String apiId;

}
