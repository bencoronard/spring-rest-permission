package dev.hireben.demo.rest.permission.application.exception;

public class NonExistentAccessRoleException extends ApplicationException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public NonExistentAccessRoleException(String message) {
    super(message);
  }

}
