package dev.hireben.demo.rest.permission.application.exception;

public class NonExistentViewAccessException extends ApplicationException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public NonExistentViewAccessException(String message) {
    super(message);
  }

}
