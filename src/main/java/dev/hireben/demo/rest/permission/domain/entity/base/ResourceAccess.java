package dev.hireben.demo.rest.permission.domain.entity.base;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class ResourceAccess {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final String name;
  private final String token;

}
