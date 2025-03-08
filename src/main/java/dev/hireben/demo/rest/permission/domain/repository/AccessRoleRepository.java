package dev.hireben.demo.rest.permission.domain.repository;

import java.util.Optional;

import dev.hireben.demo.rest.permission.domain.entity.AccessRole;

public interface AccessRoleRepository {

  String save(AccessRole role);

  Optional<AccessRole> findByName(String name);

  boolean existsByName(String name);

}
