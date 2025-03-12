package dev.hireben.demo.rest.permission.application.dto;

import java.util.Collection;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateAccessRoleDTO {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  String roleName;
  Collection<String> viewNames;
  Collection<String> apiNames;

}
