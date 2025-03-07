package dev.hireben.demo.rest.permission.application.exception;

import dev.hireben.demo.rest.permission.domain.exception.DomainException;

public class NonExistentRolePermissionException extends DomainException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public NonExistentRolePermissionException(String message) {
    super(message);
  }

}
