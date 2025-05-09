package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository.base;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ResourceEntityRepository<T, ID> extends JpaRepository<T, ID> {

  Optional<T> findByName(String name);

  boolean existsByName(String name);

  void deleteByName(String name);

  Set<T> findByNameIn(Collection<String> names);

}
