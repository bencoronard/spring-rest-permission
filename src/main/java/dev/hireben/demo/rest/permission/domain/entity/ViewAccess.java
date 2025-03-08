package dev.hireben.demo.rest.permission.domain.entity;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ViewAccess {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final String name;
  private final String token;
  private final Set<ApiAccess> linkedApis;

}
