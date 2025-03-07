package dev.hireben.demo.rest.permission.application.exception;

public class DuplicateViewAccessException extends RuntimeException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public DuplicateViewAccessException(String message) {
    super(message);
  }

}
