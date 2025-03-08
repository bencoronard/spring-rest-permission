package dev.hireben.demo.rest.permission.application.exception;

public class DuplicateApiAccessException extends ApplicationException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public DuplicateApiAccessException(String message) {
    super(message);
  }

}
