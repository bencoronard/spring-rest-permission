package dev.hireben.demo.rest.permission.application.usecase;

import java.util.Set;

import dev.hireben.demo.rest.permission.application.dto.CreateViewAccessDTO;
import dev.hireben.demo.rest.permission.application.exception.DuplicateViewAccessException;
import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import dev.hireben.demo.rest.permission.domain.repository.ViewAccessRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateViewAccessUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final ViewAccessRepository viewAccessRepository;
  private final ApiAccessRepository apiAccessRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public String execute(CreateViewAccessDTO dto) {

    if (viewAccessRepository.existsByName(dto.getViewName())) {
      throw new DuplicateViewAccessException(String.format("View access %s already exists", dto.getViewName()));
    }

    Set<ApiAccess> apiAccesses = apiAccessRepository.findByNameIn(dto.getLinkedApiNames());

    ViewAccess newViewAccess = ViewAccess.builder()
        .name(dto.getViewName())
        .token(dto.getViewToken())
        .linkedApis(apiAccesses)
        .build();

    return viewAccessRepository.save(newViewAccess);
  }

}
