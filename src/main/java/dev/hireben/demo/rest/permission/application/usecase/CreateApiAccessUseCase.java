package dev.hireben.demo.rest.permission.application.usecase;

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

  private final ViewAccessRepository viewPermissionRepository;
  private final ApiAccessRepository apiPermissionRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void execute(String apiId, String apiToken, String viewId) {

    ViewAccess associatedView = viewPermissionRepository.findById(viewId)
        .orElseThrow(() -> new NonExistentViewAccessException(String.format("View permission %s not found", viewId)));

    if (apiPermissionRepository.existsById(apiId)) {
      throw new DuplicateApiAccessException(String.format("API permission %s already exists", apiId));
    }

    ApiAccess newApiPermission = ApiAccess.builder()
        .id(apiId)
        .token(apiToken)
        .associatedView(associatedView)
        .build();

    apiPermissionRepository.save(newApiPermission);
  }

}
