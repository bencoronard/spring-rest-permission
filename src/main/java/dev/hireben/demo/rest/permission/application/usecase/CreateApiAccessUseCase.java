package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.application.dto.CreateApiAccessDTO;
import dev.hireben.demo.rest.permission.application.exception.DuplicateApiAccessException;
import dev.hireben.demo.rest.permission.application.exception.NonExistentViewAccessException;
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

  public void execute(CreateApiAccessDTO dto) {

    ViewAccess associatedView = viewAccessRepository.findById(dto.getAssociatedViewId())
        .orElseThrow(() -> new NonExistentViewAccessException(
            String.format("View permission %s not found", dto.getAssociatedViewId())));

    if (apiAccessRepository.existsById(dto.getApiId())) {
      throw new DuplicateApiAccessException(String.format("API permission %s already exists", dto.getApiId()));
    }

    ApiAccess newApiPermission = ApiAccess.builder()
        .id(dto.getApiId())
        .token(dto.getApiToken())
        .associatedView(associatedView)
        .build();

    apiAccessRepository.save(newApiPermission);
  }

}
