package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository.base;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceEntityRepository<T, ID> extends JpaRepository<T, ID> {

  Optional<T> findByName(String name);

  boolean existsByName(String name);

  void deleteByName(String name);

  Set<T> findByNameIn(Set<String> names);

}
