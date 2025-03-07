package dev.hireben.demo.rest.permission.application.exception;

import dev.hireben.demo.rest.permission.domain.exception.DomainException;

public class DuplicateApiAccessException extends DomainException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public DuplicateApiAccessException(String message) {
    super(message);
  }

}
