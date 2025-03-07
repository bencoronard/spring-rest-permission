package dev.hireben.demo.rest.permission.application.exception;

public class RolePermissionAlreadyExistsException extends RuntimeException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public RolePermissionAlreadyExistsException(String message) {
    super(message);
  }

}
