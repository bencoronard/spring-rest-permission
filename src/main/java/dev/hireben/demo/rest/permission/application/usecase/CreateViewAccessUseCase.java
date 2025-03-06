package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.application.dto.CreateAccessRoleDTO;
import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
import dev.hireben.demo.rest.permission.domain.repository.ViewAccessRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateViewAccessUseCase {

  // ---------------------------------------------------------------------------//
  // Dependencies
  // ---------------------------------------------------------------------------//

  private final ViewAccessRepository repository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public String create(CreateAccessRoleDTO dto) {

    ViewAccess access = ViewAccess.builder()
        .id(dto.getId())
        .name(dto.getName())
        .build();

    return repository.save(access);
  }

}
