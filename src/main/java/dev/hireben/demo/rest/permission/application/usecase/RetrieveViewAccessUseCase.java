package dev.hireben.demo.rest.permission.application.usecase;

import java.util.Collection;

import dev.hireben.demo.rest.permission.domain.repository.ViewAccessRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RetrieveViewAccessUseCase {

  // ---------------------------------------------------------------------------//
  // Dependencies
  // ---------------------------------------------------------------------------//

  private ViewAccessRepository repository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public Collection<String> findViewAccessNamesByIds(Collection<String> ids) {
    return repository.findNameById(ids);
  }

}
