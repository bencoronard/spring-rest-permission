package dev.hireben.demo.rest.permission.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiAccess {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final String id;
  private final String token;
  private final ViewAccess associatedView;

}
