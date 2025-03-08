package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.application.dto.UpdateViewAccessDTO;
import dev.hireben.demo.rest.permission.application.exception.NonExistentViewAccessException;
import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
import dev.hireben.demo.rest.permission.domain.repository.ViewAccessRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateViewAccessUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final ViewAccessRepository viewAccessRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void execute(String viewName, UpdateViewAccessDTO dto) {

    ViewAccess viewAccess = viewAccessRepository.findByName(viewName)
        .orElseThrow(() -> new NonExistentViewAccessException(String.format("View access %s not found", viewName)));

    if (dto.getNewViewName() != null) {
      viewAccess.setName(dto.getNewViewName());
    }
    if (dto.getNewViewToken() != null) {
      viewAccess.setToken(dto.getNewViewToken());
    }

    viewAccessRepository.save(viewAccess);
  }

}
