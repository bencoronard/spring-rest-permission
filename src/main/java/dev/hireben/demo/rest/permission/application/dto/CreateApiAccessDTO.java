package dev.hireben.demo.rest.permission.application.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateApiAccessDTO {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  String apiName;
  String apiToken;
  Set<String> linkedViewNames;

}
