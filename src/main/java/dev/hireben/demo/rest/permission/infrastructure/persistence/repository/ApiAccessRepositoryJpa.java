package dev.hireben.demo.rest.permission.infrastructure.persistence.repository;

import org.springframework.stereotype.Repository;

import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import dev.hireben.demo.rest.permission.domain.repository.ApiAccessRepository;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.ApiAccessEntity;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.mapper.ApiAccessEntityMapper;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository.ApiAccessEntityRepository;
import dev.hireben.demo.rest.permission.infrastructure.persistence.repository.base.ResourceRepositoryJpa;

@Repository
public class ApiAccessRepositoryJpa extends
    ResourceRepositoryJpa<ApiAccessEntity, ApiAccess, Long, ApiAccessEntityRepository>
    implements ApiAccessRepository {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  protected ApiAccessRepositoryJpa(ApiAccessEntityRepository repository) {
    super(repository);
  }

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  @Override
  protected String extractIdentifier(ApiAccessEntity entity) {
    return entity.getName();
  }

  // ---------------------------------------------------------------------------//

  @Override
  protected ApiAccessEntity toEntity(ApiAccess domain) {
    return ApiAccessEntityMapper.toEntity(domain);
  }

  // ---------------------------------------------------------------------------//

  @Override
  protected ApiAccess toDomain(ApiAccessEntity entity) {
    return ApiAccessEntityMapper.toDomain(entity);
  }

}
