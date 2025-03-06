package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.application.dto.CreateAccessRoleDTO;
import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateApiAccessUseCase {

  // ---------------------------------------------------------------------------//
  // Dependencies
  // ---------------------------------------------------------------------------//

  private final ApiAccessRepository repository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public String create(CreateAccessRoleDTO dto) {

    ApiAccess access = ApiAccess.builder()
        .id(dto.getId())
        .name(dto.getName())
        .build();

    return repository.save(access);
  }

}
