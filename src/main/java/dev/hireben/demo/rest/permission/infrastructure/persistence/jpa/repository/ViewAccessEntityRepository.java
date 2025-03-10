package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.ViewAccessEntity;

public interface ViewAccessEntityRepository extends JpaRepository<ViewAccessEntity, Long> {

  Optional<ViewAccessEntity> findByName(String name);

  Set<ViewAccessEntity> findByNameIn(Collection<String> names);

  boolean existsByName(String name);

  void deleteByName(String name);

}
