package dev.hireben.demo.rest.permission.application.usecase;

import java.util.Set;

import dev.hireben.demo.rest.permission.application.dto.CreateApiAccessDTO;
import dev.hireben.demo.rest.permission.application.exception.DuplicateApiAccessException;
import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import dev.hireben.demo.rest.permission.domain.repository.ViewAccessRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateApiAccessUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final ViewAccessRepository viewAccessRepository;
  private final ApiAccessRepository apiAccessRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public String execute(CreateApiAccessDTO dto) {

    if (apiAccessRepository.existsByName(dto.getApiName())) {
      throw new DuplicateApiAccessException(String.format("API access %s already exists", dto.getApiName()));
    }

    Set<ViewAccess> viewAccesses = viewAccessRepository.findByNameIn(dto.getLinkedViewNames());

    ApiAccess newApiAccess = ApiAccess.builder()
        .name(dto.getApiName())
        .token(dto.getApiToken())
        .linkedViews(viewAccesses)
        .build();

    return apiAccessRepository.save(newApiAccess);
  }

}
