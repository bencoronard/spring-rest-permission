package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.application.exception.ApiAccessAlreadyExistsException;
import dev.hireben.demo.rest.permission.application.exception.ViewAccessNotFoundException;
import dev.hireben.demo.rest.permission.application.port.ApiAccessRepository;
import dev.hireben.demo.rest.permission.application.port.ViewAccessRepository;
import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
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
        .orElseThrow(() -> new ViewAccessNotFoundException(String.format("View permission %s not found", viewId)));

    if (apiPermissionRepository.existsById(apiId)) {
      throw new ApiAccessAlreadyExistsException(String.format("API permission %s already exists", apiId));
    }

    ApiAccess newApiPermission = ApiAccess.builder()
        .id(apiId)
        .token(apiToken)
        .associatedView(associatedView)
        .build();

    apiPermissionRepository.save(newApiPermission);
  }

}
