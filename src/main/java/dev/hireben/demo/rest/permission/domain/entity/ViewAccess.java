package dev.hireben.demo.rest.permission.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ViewAccess {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final String id;
  private String name;

}
