package dev.hireben.demo.rest.permission.application.port;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;

public interface ApiAccessRepository {

  String save(ApiAccess permission);

  Optional<ApiAccess> findById(String id);

  Set<ApiAccess> findByIds(Collection<String> ids);

  boolean existsById(String id);

}
