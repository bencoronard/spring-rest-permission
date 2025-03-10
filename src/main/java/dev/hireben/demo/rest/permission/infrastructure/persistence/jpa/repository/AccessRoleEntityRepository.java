package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.AccessRoleEntity;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository.base.ResourceEntityRepository;

public interface AccessRoleEntityRepository
    extends ResourceEntityRepository<AccessRoleEntity, Long>, JpaRepository<AccessRoleEntity, Long> {
}
