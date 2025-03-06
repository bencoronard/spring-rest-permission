package dev.hireben.demo.rest.permission.presentation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.hireben.demo.rest.permission.application.usecase.CreateAccessPermissionUseCase;
import dev.hireben.demo.rest.permission.application.usecase.CreateAccessRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.CreateApiAccessUseCase;
import dev.hireben.demo.rest.permission.application.usecase.CreateViewAccessUseCase;
import dev.hireben.demo.rest.permission.application.usecase.RetrieveAccessPermissionUseCase;
import dev.hireben.demo.rest.permission.application.usecase.RetrieveApiAccessUseCase;
import dev.hireben.demo.rest.permission.application.usecase.RetrieveViewAccessUseCase;
import dev.hireben.demo.rest.permission.domain.repository.AccessPermissionRepository;
import dev.hireben.demo.rest.permission.domain.repository.AccessRoleRepository;
import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import dev.hireben.demo.rest.permission.domain.repository.ViewAccessRepository;

@Configuration
public class UseCaseConfig {

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  @Bean
  CreateAccessPermissionUseCase createAccessPermissionUseCase(AccessPermissionRepository repository) {
    return new CreateAccessPermissionUseCase(repository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  CreateAccessRoleUseCase createAccessRoleUseCase(AccessRoleRepository repository) {
    return new CreateAccessRoleUseCase(repository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  CreateApiAccessUseCase createApiAccessUseCase(ApiAccessRepository repository) {
    return new CreateApiAccessUseCase(repository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  CreateViewAccessUseCase createViewAccessUseCase(ViewAccessRepository repository) {
    return new CreateViewAccessUseCase(repository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  RetrieveAccessPermissionUseCase retrieveAccessPermissionUseCase(AccessPermissionRepository repository) {
    return new RetrieveAccessPermissionUseCase(repository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  RetrieveApiAccessUseCase retrieveApiAccessUseCase(ApiAccessRepository repository) {
    return new RetrieveApiAccessUseCase(repository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  RetrieveViewAccessUseCase retrieveViewAccessUseCase(ViewAccessRepository repository) {
    return new RetrieveViewAccessUseCase(repository);
  }

}
