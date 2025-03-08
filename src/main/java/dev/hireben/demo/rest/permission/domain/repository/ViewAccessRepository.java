package dev.hireben.demo.rest.permission.domain.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;

public interface ViewAccessRepository {

  String save(ViewAccess access);

  Optional<ViewAccess> findByName(String name);

  Set<ViewAccess> findByNameIn(Collection<String> names);

  boolean existsByName(String name);

}
