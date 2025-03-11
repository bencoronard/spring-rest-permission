package dev.hireben.demo.rest.permission.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.hireben.demo.rest.permission.application.usecase.AssignApiAccessToRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.AssignApiAccessToViewUseCase;
import dev.hireben.demo.rest.permission.domain.repository.AccessRoleRepository;
import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import dev.hireben.demo.rest.permission.domain.repository.ViewAccessRepository;

@Configuration
public class UseCaseConfig {

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  @Bean
  AssignApiAccessToRoleUseCase assignApiAccessToRoleUseCase(
      AccessRoleRepository accessRoleRepository,
      ApiAccessRepository apiAccessRepository) {
    return new AssignApiAccessToRoleUseCase(accessRoleRepository, apiAccessRepository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  AssignApiAccessToViewUseCase assignApiAccessToViewUseCase(
      ViewAccessRepository viewAccessRepository,
      ApiAccessRepository apiAccessRepository) {
    return new AssignApiAccessToViewUseCase(viewAccessRepository, apiAccessRepository);
  }

  // ---------------------------------------------------------------------------//

}
