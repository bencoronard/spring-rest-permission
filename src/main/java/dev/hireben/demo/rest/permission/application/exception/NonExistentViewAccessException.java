package dev.hireben.demo.rest.permission.application.exception;

import dev.hireben.demo.rest.permission.domain.exception.DomainException;

public class NonExistentViewAccessException extends DomainException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public NonExistentViewAccessException(String message) {
    super(message);
  }

}
