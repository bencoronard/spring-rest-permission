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

  public void execute(CreateViewAccessDTO dto) {

    Set<ApiAccess> associatedApis = apiAccessRepository.findByIds(dto.getAssociatedApiIds());

    if (viewAccessRepository.existsById(dto.getViewId())) {
      throw new DuplicateViewAccessException(String.format("View permission %s already exists", dto.getViewId()));
    }

    ViewAccess newViewPermission = ViewAccess.builder()
        .id(dto.getViewId())
        .token(dto.getViewToken())
        .associatedApis(associatedApis)
        .build();

    viewAccessRepository.save(newViewPermission);
  }

}
