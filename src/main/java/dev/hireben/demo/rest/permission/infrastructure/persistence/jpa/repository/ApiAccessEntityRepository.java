package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.ApiAccessEntity;

public interface ApiAccessEntityRepository extends JpaRepository<ApiAccessEntity, Long> {

  Optional<ApiAccessEntity> findByName(String name);

  Set<ApiAccessEntity> findByNameIn(Collection<String> names);

  boolean existsByName(String name);

  void deleteByName(String name);

}
