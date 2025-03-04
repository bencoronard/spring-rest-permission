package dev.hireben.demo.rest.permission.application.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateApiAccessDTO {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  String id;
  String name;

}
