package dev.hireben.demo.rest.permission.application.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateAccessRoleDTO {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  String roleName;
  Set<String> viewNames;
  Set<String> apiNames;

}
