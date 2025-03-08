package dev.hireben.demo.rest.permission.domain.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface DomainRepository<T> {

  String save(T entity);

  Optional<T> findByName(String name);

  Set<T> findByNameIn(Collection<String> names);

  boolean existsByName(String name);

  void deleteByName(String name);

}
