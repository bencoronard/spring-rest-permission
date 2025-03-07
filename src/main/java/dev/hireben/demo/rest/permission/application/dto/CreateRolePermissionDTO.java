package dev.hireben.demo.rest.permission.application.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateRolePermissionDTO {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  String roleId;
  Set<String> viewIds;
  Set<String> apiIds;

}
