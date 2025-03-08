package dev.hireben.demo.rest.permission.domain.entity;

import java.util.Set;

import dev.hireben.demo.rest.permission.domain.entity.base.ResourceAccess;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ViewAccess extends ResourceAccess {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final Set<ApiAccess> linkedApis;

}
