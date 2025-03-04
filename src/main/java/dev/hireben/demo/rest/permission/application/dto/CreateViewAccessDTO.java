package dev.hireben.demo.rest.permission.application.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateViewAccessDTO {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  String id;
  String name;

}
