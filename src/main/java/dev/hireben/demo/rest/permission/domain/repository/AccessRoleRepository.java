package dev.hireben.demo.rest.permission.domain.repository;

import dev.hireben.demo.rest.permission.domain.entity.AccessRole;

public interface AccessRoleRepository {

  String save(AccessRole role);

}
