package dev.hireben.demo.rest.permission.application.exception;

import dev.hireben.demo.rest.permission.domain.exception.DomainException;

public class NonExistentApiAccessException extends DomainException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public NonExistentApiAccessException(String message) {
    super(message);
  }

}
