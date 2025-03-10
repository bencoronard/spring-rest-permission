package dev.hireben.demo.rest.permission.application.usecase;

import java.util.Collection;
import java.util.Set;

import dev.hireben.demo.rest.permission.application.exception.NonExistentViewAccessException;
import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import dev.hireben.demo.rest.permission.domain.repository.ViewAccessRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UnassignApiAccessFromViewUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final ViewAccessRepository viewAccessRepository;
  private final ApiAccessRepository apiAccessRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void execute(String viewName, Collection<String> apiNames) {

    ViewAccess view = viewAccessRepository.findByName(viewName)
        .orElseThrow(() -> new NonExistentViewAccessException(String.format("View %s not found", viewName)));

    Set<ApiAccess> apis = apiAccessRepository.findByNameIn(apiNames);

    view.getLinkedApis().removeAll(apis);

    viewAccessRepository.save(view);
  }

}
