package dev.hireben.demo.rest.permission.domain.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;

public interface ApiAccessRepository {

  String save(ApiAccess access);

  Optional<ApiAccess> findByName(String name);

  Set<ApiAccess> findByNameIn(Collection<String> names);

  boolean existsByName(String name);

}
