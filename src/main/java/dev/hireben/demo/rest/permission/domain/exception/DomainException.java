package dev.hireben.demo.rest.permission.domain.exception;

public abstract class DomainException extends RuntimeException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  protected DomainException(String message) {
    super(message);
  }

}
