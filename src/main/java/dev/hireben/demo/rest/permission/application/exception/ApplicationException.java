package dev.hireben.demo.rest.permission.application.exception;

public abstract class ApplicationException extends RuntimeException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  protected ApplicationException(String message) {
    super(message);
  }

}
