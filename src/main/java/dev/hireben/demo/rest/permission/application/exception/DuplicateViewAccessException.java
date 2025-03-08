package dev.hireben.demo.rest.permission.application.exception;

import dev.hireben.demo.rest.permission.application.exception.base.ApplicationException;

public class DuplicateViewAccessException extends ApplicationException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public DuplicateViewAccessException(String message) {
    super(message);
  }

}
