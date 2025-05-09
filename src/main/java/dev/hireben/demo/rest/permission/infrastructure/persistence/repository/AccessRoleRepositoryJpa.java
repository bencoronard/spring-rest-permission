package dev.hireben.demo.rest.permission.infrastructure.persistence.repository;

import org.springframework.stereotype.Repository;

import dev.hireben.demo.rest.permission.domain.entity.AccessRole;
import dev.hireben.demo.rest.permission.domain.repository.AccessRoleRepository;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.AccessRoleEntity;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.mapper.AccessRoleEntityMapper;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository.AccessRoleEntityRepository;
import dev.hireben.demo.rest.permission.infrastructure.persistence.repository.base.ResourceRepositoryJpa;

@Repository
public class AccessRoleRepositoryJpa
    extends ResourceRepositoryJpa<AccessRoleEntity, AccessRole, AccessRoleEntityRepository>
    implements AccessRoleRepository {

  // ---------------------------------------------------------------------------//
  // Constructors
  // ---------------------------------------------------------------------------//

  protected AccessRoleRepositoryJpa(AccessRoleEntityRepository repository) {
    super(repository);

  }

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  @Override
  protected String extractIdentifier(AccessRoleEntity entity) {
    return entity.getName();
  }

  // ---------------------------------------------------------------------------//

  @Override
  protected AccessRoleEntity toEntity(AccessRole domain) {
    return AccessRoleEntityMapper.toEntity(domain);
  }

  // ---------------------------------------------------------------------------//

  @Override
  protected AccessRole toDomain(AccessRoleEntity entity) {
    return AccessRoleEntityMapper.toDomain(entity);
  }

}
