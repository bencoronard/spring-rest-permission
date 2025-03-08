package dev.hireben.demo.rest.permission.application.usecase;

import dev.hireben.demo.rest.permission.application.dto.UpdateApiAccessDTO;
import dev.hireben.demo.rest.permission.application.exception.NonExistentApiAccessException;
import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateApiAccessUseCase {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final ApiAccessRepository apiAccessRepository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public void execute(String apiName, UpdateApiAccessDTO dto) {

    ApiAccess apiAccess = apiAccessRepository.findByName(apiName)
        .orElseThrow(() -> new NonExistentApiAccessException(String.format("API access %s not found", apiName)));

    if (dto.getNewApiName() != null) {
      apiAccess.setName(dto.getNewApiName());
    }
    if (dto.getNewApiToken() != null) {
      apiAccess.setToken(dto.getNewApiToken());
    }

    apiAccessRepository.save(apiAccess);
  }

}
