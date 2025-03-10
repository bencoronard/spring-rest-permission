package dev.hireben.demo.rest.permission.infrastructure.persistence.repository;

import org.springframework.stereotype.Repository;

import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
import dev.hireben.demo.rest.permission.domain.repository.ViewAccessRepository;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.ViewAccessEntity;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.mapper.ViewAccessEntityMapper;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository.ViewAccessEntityRepository;
import dev.hireben.demo.rest.permission.infrastructure.persistence.repository.base.ResourceRepositoryJpa;

@Repository
public class ViewAccessRepositoryJpa
    extends ResourceRepositoryJpa<ViewAccessEntity, ViewAccess, Long, ViewAccessEntityRepository>
    implements ViewAccessRepository {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  protected ViewAccessRepositoryJpa(ViewAccessEntityRepository repository) {
    super(repository);
  }

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  @Override
  protected String extractIdentifier(ViewAccessEntity entity) {
    return entity.getPath();
  }

  // ---------------------------------------------------------------------------//

  @Override
  protected ViewAccessEntity toEntity(ViewAccess domain) {
    return ViewAccessEntityMapper.toEntity(domain);
  }

  // ---------------------------------------------------------------------------//

  @Override
  protected ViewAccess toDomain(ViewAccessEntity entity) {
    return ViewAccessEntityMapper.toDomain(entity);
  }

}
