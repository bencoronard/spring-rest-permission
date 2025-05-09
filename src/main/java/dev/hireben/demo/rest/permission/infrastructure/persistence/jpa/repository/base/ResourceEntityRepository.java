package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository.base;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface ResourceEntityRepository<T> {

  T save(T entity);

  Optional<T> findByName(String name);

  boolean existsByName(String name);

  void deleteByName(String name);

  Set<T> findByNameIn(Collection<String> names);

}
