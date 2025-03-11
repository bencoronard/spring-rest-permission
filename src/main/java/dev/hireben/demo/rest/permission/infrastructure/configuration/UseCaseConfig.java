package dev.hireben.demo.rest.permission.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.hireben.demo.rest.permission.application.usecase.AssignApiAccessToRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.AssignApiAccessToViewUseCase;
import dev.hireben.demo.rest.permission.application.usecase.AssignViewAccessToRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.CheckApiAccessByRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.CheckViewAccessByRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.CreateAccessRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.CreateApiAccessUseCase;
import dev.hireben.demo.rest.permission.application.usecase.CreateViewAccessUseCase;
import dev.hireben.demo.rest.permission.application.usecase.DeleteAccessRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.DeleteApiAccessUseCase;
import dev.hireben.demo.rest.permission.application.usecase.DeleteViewAccessUseCase;
import dev.hireben.demo.rest.permission.application.usecase.UnassignApiAccessFromRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.UnassignApiAccessFromViewUseCase;
import dev.hireben.demo.rest.permission.application.usecase.UnassignViewAccessFromRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.UpdateApiAccessUseCase;
import dev.hireben.demo.rest.permission.application.usecase.UpdateViewAccessUseCase;
import dev.hireben.demo.rest.permission.domain.repository.AccessRoleRepository;
import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import dev.hireben.demo.rest.permission.domain.repository.ViewAccessRepository;

@Configuration
public class UseCaseConfig {

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  @Bean
  CheckApiAccessByRoleUseCase checkApiAccessByRoleUseCase(
      AccessRoleRepository accessRoleRepository) {
    return new CheckApiAccessByRoleUseCase(accessRoleRepository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  CheckViewAccessByRoleUseCase checkViewAccessByRoleUseCase(
      AccessRoleRepository accessRoleRepository) {
    return new CheckViewAccessByRoleUseCase(accessRoleRepository);
  }

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

  @Bean
  AssignViewAccessToRoleUseCase assignViewAccessToRoleUseCase(
      AccessRoleRepository accessRoleRepository,
      ViewAccessRepository viewAccessRepository) {
    return new AssignViewAccessToRoleUseCase(accessRoleRepository, viewAccessRepository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  UnassignApiAccessFromRoleUseCase unassignApiAccessFromRoleUseCase(
      AccessRoleRepository accessRoleRepository,
      ApiAccessRepository apiAccessRepository) {
    return new UnassignApiAccessFromRoleUseCase(accessRoleRepository, apiAccessRepository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  UnassignApiAccessFromViewUseCase unassignApiAccessFromViewUseCase(
      ViewAccessRepository viewAccessRepository,
      ApiAccessRepository apiAccessRepository) {
    return new UnassignApiAccessFromViewUseCase(viewAccessRepository, apiAccessRepository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  UnassignViewAccessFromRoleUseCase unassignViewAccessFromRoleUseCase(
      AccessRoleRepository accessRoleRepository,
      ViewAccessRepository viewAccessRepository) {
    return new UnassignViewAccessFromRoleUseCase(accessRoleRepository, viewAccessRepository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  CreateAccessRoleUseCase createAccessRoleUseCase(
      AccessRoleRepository accessRoleRepository,
      ViewAccessRepository viewAccessRepository,
      ApiAccessRepository apiAccessRepository) {
    return new CreateAccessRoleUseCase(accessRoleRepository, viewAccessRepository, apiAccessRepository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  CreateApiAccessUseCase createApiAccessUseCase(
      ViewAccessRepository viewAccessRepository,
      ApiAccessRepository apiAccessRepository) {
    return new CreateApiAccessUseCase(viewAccessRepository, apiAccessRepository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  CreateViewAccessUseCase createViewAccessUseCase(
      ViewAccessRepository viewAccessRepository,
      ApiAccessRepository apiAccessRepository) {
    return new CreateViewAccessUseCase(viewAccessRepository, apiAccessRepository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  UpdateApiAccessUseCase updateApiAccessUseCase(
      ApiAccessRepository apiAccessRepository) {
    return new UpdateApiAccessUseCase(apiAccessRepository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  UpdateViewAccessUseCase updateViewAccessUseCase(
      ViewAccessRepository viewAccessRepository) {
    return new UpdateViewAccessUseCase(viewAccessRepository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  DeleteAccessRoleUseCase deleteAccessRoleUseCase(
      AccessRoleRepository accessRoleRepository) {
    return new DeleteAccessRoleUseCase(accessRoleRepository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  DeleteApiAccessUseCase deleteApiAccessUseCase(
      ApiAccessRepository apiAccessRepository) {
    return new DeleteApiAccessUseCase(apiAccessRepository);
  }

  // ---------------------------------------------------------------------------//

  @Bean
  DeleteViewAccessUseCase deleteViewAccessUseCase(
      ViewAccessRepository viewAccessRepository) {
    return new DeleteViewAccessUseCase(viewAccessRepository);
  }

}
