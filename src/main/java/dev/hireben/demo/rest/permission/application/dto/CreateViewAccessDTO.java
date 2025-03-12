package dev.hireben.demo.rest.permission.application.dto;

import java.util.Collection;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateViewAccessDTO {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  String viewName;
  String viewToken;
  Collection<String> linkedApiNames;

}
