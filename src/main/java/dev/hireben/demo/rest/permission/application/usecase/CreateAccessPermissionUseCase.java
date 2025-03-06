package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.application.dto.CreateAccessPermissionDTO;
import dev.hireben.demo.rest.permission.domain.entity.AccessPermission;
import dev.hireben.demo.rest.permission.domain.repository.AccessPermissionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAccessPermissionUseCase {

  // ---------------------------------------------------------------------------//
  // Dependencies
  // ---------------------------------------------------------------------------//

  private final AccessPermissionRepository repository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void create(CreateAccessPermissionDTO dto) {

    AccessPermission permission = AccessPermission.builder()
        .roleId(dto.getRoleId())
        .viewId(dto.getViewId())
        .apiId(dto.getApiId())
        .build();

    repository.save(permission);
  }

}
