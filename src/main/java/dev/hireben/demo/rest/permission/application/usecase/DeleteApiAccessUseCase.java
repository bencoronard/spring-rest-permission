package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteApiAccessUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final ApiAccessRepository apiAccessRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void execute(String apiName) {
    apiAccessRepository.deleteByName(apiName);
  }

}
