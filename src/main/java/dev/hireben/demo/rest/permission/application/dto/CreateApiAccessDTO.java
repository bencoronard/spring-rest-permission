package dev.hireben.demo.rest.permission.application.dto;

import java.util.Collection;
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
  Collection<String> linkedViewNames;

}
