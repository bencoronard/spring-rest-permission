package dev.hireben.demo.rest.permission.application.exception;

import dev.hireben.demo.rest.permission.application.exception.base.ApplicationException;

public class NonExistentAccessRoleException extends ApplicationException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public NonExistentAccessRoleException(String message) {
    super(message);
  }

}
