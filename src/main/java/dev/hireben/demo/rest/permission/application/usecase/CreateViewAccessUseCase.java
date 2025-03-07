package dev.hireben.demo.rest.permission.application.usecase;

import java.util.Set;

import dev.hireben.demo.rest.permission.application.exception.DuplicateViewAccessException;
import dev.hireben.demo.rest.permission.application.repository.ApiAccessRepository;
import dev.hireben.demo.rest.permission.application.repository.ViewAccessRepository;
import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateViewAccessUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final ViewAccessRepository viewPermissionRepository;
  private final ApiAccessRepository apiPermissionRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void execute(String viewId, String viewToken, Set<String> apiIds) {

    Set<ApiAccess> associatedApis = apiPermissionRepository.findByIds(apiIds);

    if (viewPermissionRepository.existsById(viewId)) {
      throw new DuplicateViewAccessException(String.format("View permission %s already exists", viewId));
    }

    ViewAccess newViewPermission = ViewAccess.builder()
        .id(viewId)
        .token(viewToken)
        .associatedApis(associatedApis)
        .build();

    viewPermissionRepository.save(newViewPermission);
  }

}
