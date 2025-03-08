package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.domain.repository.AccessRoleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteAccessRoleUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final AccessRoleRepository accessRoleRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void execute(String roleName) {
    accessRoleRepository.deleteByName(roleName);
  }

}
