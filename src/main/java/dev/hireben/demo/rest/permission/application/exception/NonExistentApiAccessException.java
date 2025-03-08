package dev.hireben.demo.rest.permission.application.exception;

public class NonExistentApiAccessException extends ApplicationException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public NonExistentApiAccessException(String message) {
    super(message);
  }

}
