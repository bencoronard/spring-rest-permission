package dev.hireben.demo.rest.permission.application.exception;

public class DuplicateRolePermissionException extends RuntimeException {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  public DuplicateRolePermissionException(String message) {
    super(message);
  }

}
