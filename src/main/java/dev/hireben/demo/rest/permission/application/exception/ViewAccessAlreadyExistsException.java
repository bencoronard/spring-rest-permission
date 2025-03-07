package dev.hireben.demo.rest.permission.application.exception;

public class ViewAccessAlreadyExistsException extends RuntimeException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public ViewAccessAlreadyExistsException(String message) {
    super(message);
  }

}
