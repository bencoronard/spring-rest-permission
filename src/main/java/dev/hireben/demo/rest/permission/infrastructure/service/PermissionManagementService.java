package dev.hireben.demo.rest.permission.infrastructure.service;

import org.hibernate.sql.Delete;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.hireben.demo.rest.permission.application.usecase.AssignApiAccessToRoleUseCase;
import dev.hireben.demo.rest.permission.application.usecase.AssignApiAccessToViewUseCase;
import dev.hireben.demo.rest.permission.application.usecase.AssignViewAccessToRoleUseCase;
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
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@SuppressWarnings("unused")
public class PermissionManagementService {

  // ---------------------------------------------------------------------------//
  // Dependencies
  // ---------------------------------------------------------------------------//

  private final AssignApiAccessToRoleUseCase assignApiAccessToRoleUseCase;
  private final AssignApiAccessToViewUseCase assignApiAccessToViewUseCase;
  private final AssignViewAccessToRoleUseCase assignViewAccessToRoleUseCase;

  private final UnassignApiAccessFromRoleUseCase unassignApiAccessFromRoleUseCase;
  private final UnassignApiAccessFromViewUseCase unassignApiAccessFromViewUseCase;
  private final UnassignViewAccessFromRoleUseCase unassignViewAccessFromRoleUseCase;

  private final CreateAccessRoleUseCase createAccessRoleUseCase;
  private final CreateApiAccessUseCase createApiAccessUseCase;
  private final CreateViewAccessUseCase createViewAccessUseCase;

  private final UpdateApiAccessUseCase updateApiAccessUseCase;
  private final UpdateViewAccessUseCase updateViewAccessUseCase;

  private final DeleteAccessRoleUseCase deleteAccessRoleUseCase;
  private final DeleteApiAccessUseCase deleteApiAccessUseCase;
  private final DeleteViewAccessUseCase deleteViewAccessUseCase;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

}
