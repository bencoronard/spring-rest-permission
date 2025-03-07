package dev.hireben.demo.rest.permission.application.exception;

public class NonExistentApiAccessException extends RuntimeException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public NonExistentApiAccessException(String message) {
    super(message);
  }

}
