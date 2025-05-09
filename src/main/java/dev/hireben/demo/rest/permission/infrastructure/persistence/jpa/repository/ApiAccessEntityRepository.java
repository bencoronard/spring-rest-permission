package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository;

import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.ApiAccessEntity;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository.base.ResourceEntityRepository;

public interface ApiAccessEntityRepository extends ResourceEntityRepository<ApiAccessEntity, Long> {
}
