package dev.hireben.demo.rest.permission.application.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateAccessPermissionDTO {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  String roleId;
  String viewId;
  String apiId;

}
