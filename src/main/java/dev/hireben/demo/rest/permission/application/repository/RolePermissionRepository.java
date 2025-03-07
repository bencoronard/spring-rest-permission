package dev.hireben.demo.rest.permission.application.repository;

import java.util.Optional;

import dev.hireben.demo.rest.permission.domain.entity.RolePermission;

public interface RolePermissionRepository {

  String save(RolePermission role);

  Optional<RolePermission> findById(String id);

  boolean existsById(String id);

}
