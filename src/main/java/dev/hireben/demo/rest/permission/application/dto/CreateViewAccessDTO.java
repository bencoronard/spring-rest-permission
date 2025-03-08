package dev.hireben.demo.rest.permission.application.dto;

import java.util.Set;

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
  Set<String> linkedApiNames;

}
