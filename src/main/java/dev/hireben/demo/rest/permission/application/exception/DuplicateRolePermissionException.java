package dev.hireben.demo.rest.permission.application.exception;

import dev.hireben.demo.rest.permission.domain.exception.DomainException;

public class DuplicateRolePermissionException extends DomainException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public DuplicateRolePermissionException(String message) {
    super(message);
  }

}
