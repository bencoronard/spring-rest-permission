package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.AccessRoleEntity;

public interface AccessRoleEntityRepository extends JpaRepository<AccessRoleEntity, Long> {

  Optional<AccessRoleEntity> findByName(String name);

  boolean existsByName(String name);

  void deleteByName(String name);

}
