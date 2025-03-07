package dev.hireben.demo.rest.permission.application.exception;

public class NonExistentRolePermissionException extends RuntimeException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public NonExistentRolePermissionException(String message) {
    super(message);
  }

}
