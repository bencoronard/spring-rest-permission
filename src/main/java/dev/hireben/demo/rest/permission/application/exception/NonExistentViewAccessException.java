package dev.hireben.demo.rest.permission.application.exception;

import dev.hireben.demo.rest.permission.application.exception.base.ApplicationException;

public class NonExistentViewAccessException extends ApplicationException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public NonExistentViewAccessException(String message) {
    super(message);
  }

}
