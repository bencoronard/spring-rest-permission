package dev.hireben.demo.rest.permission.application.usecase;

import java.util.Collection;

import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RetrieveApiAccessUseCase {

  // ---------------------------------------------------------------------------//
  // Dependencies
  // ---------------------------------------------------------------------------//

  private final ApiAccessRepository repository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public Collection<String> findApiAccessNamesByIds(Collection<String> ids) {
    return repository.findNameById(ids);
  }

}
