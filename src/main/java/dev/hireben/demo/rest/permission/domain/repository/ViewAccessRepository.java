package dev.hireben.demo.rest.permission.domain.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;

public interface ViewAccessRepository {

  String save(ViewAccess permission);

  Optional<ViewAccess> findById(String id);

  Set<ViewAccess> findByIds(Collection<String> ids);

  boolean existsById(String id);

}
