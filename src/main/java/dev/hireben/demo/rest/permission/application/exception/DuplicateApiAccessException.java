package dev.hireben.demo.rest.permission.application.exception;

import dev.hireben.demo.rest.permission.application.exception.base.ApplicationException;

public class DuplicateApiAccessException extends ApplicationException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public DuplicateApiAccessException(String message) {
    super(message);
  }

}
