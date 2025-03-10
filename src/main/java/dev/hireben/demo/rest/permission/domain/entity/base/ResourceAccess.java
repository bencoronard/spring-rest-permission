package dev.hireben.demo.rest.permission.domain.entity.base;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class ResourceAccess {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private Long id;
  private String name;
  private String token;

}
