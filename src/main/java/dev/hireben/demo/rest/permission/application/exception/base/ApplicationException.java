package dev.hireben.demo.rest.permission.application.exception.base;

public abstract class ApplicationException extends RuntimeException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  protected ApplicationException(String message) {
    super(message);
  }

}
