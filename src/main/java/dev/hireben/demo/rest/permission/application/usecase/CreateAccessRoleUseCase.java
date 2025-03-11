package dev.hireben.demo.rest.permission.application.usecase;

import java.util.Set;

import dev.hireben.demo.rest.permission.application.dto.CreateAccessRoleDTO;
import dev.hireben.demo.rest.permission.application.exception.DuplicateAccessRoleException;
import dev.hireben.demo.rest.permission.domain.entity.AccessRole;
import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import dev.hireben.demo.rest.permission.domain.repository.AccessRoleRepository;
import dev.hireben.demo.rest.permission.domain.repository.ViewAccessRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAccessRoleUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final AccessRoleRepository accessRoleRepository;
  private final ViewAccessRepository viewAccessRepository;
  private final ApiAccessRepository apiAccessRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public String execute(CreateAccessRoleDTO dto) {

    if (accessRoleRepository.existsByName(dto.getRoleName())) {
      throw new DuplicateAccessRoleException(String.format("Role %s already exists", dto.getRoleName()));
    }

    Set<ViewAccess> viewAccesses = viewAccessRepository.findByNameIn(dto.getViewNames());
    Set<ApiAccess> apiAccesses = apiAccessRepository.findByNameIn(dto.getApiNames());

    AccessRole newRole = AccessRole.builder()
        .name(dto.getRoleName())
        .viewAccesses(viewAccesses)
        .apiAccesses(apiAccesses)
        .build();

    return accessRoleRepository.save(newRole);
  }

}
