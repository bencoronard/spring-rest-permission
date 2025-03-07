package dev.hireben.demo.rest.permission.application.exception;

public class NonExistentViewAccessException extends RuntimeException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public NonExistentViewAccessException(String message) {
    super(message);
  }

}
