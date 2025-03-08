package dev.hireben.demo.rest.permission.application.exception;

import dev.hireben.demo.rest.permission.application.exception.base.ApplicationException;

public class NonExistentApiAccessException extends ApplicationException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public NonExistentApiAccessException(String message) {
    super(message);
  }

}
