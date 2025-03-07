package dev.hireben.demo.rest.permission.application.exception;

public class ApiAccessNotFoundException extends RuntimeException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public ApiAccessNotFoundException(String message) {
    super(message);
  }

}
