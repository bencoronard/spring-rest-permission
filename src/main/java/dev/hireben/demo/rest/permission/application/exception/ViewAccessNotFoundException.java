package dev.hireben.demo.rest.permission.application.exception;

public class ViewAccessNotFoundException extends RuntimeException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public ViewAccessNotFoundException(String message) {
    super(message);
  }

}
