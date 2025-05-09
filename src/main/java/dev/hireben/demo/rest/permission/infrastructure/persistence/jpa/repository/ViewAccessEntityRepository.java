package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.ViewAccessEntity;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository.base.ResourceEntityRepository;

public interface ViewAccessEntityRepository
    extends ResourceEntityRepository<ViewAccessEntity>, JpaRepository<ViewAccessEntity, Long> {
}
