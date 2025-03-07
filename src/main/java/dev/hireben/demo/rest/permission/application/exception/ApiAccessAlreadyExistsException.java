package dev.hireben.demo.rest.permission.application.exception;

public class ApiAccessAlreadyExistsException extends RuntimeException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public ApiAccessAlreadyExistsException(String message) {
    super(message);
  }

}
