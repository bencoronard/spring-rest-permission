package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.mapper;

import java.util.stream.Collectors;

import dev.hireben.demo.rest.permission.domain.entity.AccessRole;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.AccessRoleEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccessRoleEntityMapper {

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public AccessRoleEntity toEntity(AccessRole domain) {
    return AccessRoleEntity.builder()
        .id(domain.getId())
        .name(domain.getName())
        .viewAccesses(domain.getViewAccesses().stream()
            .map(ViewAccessEntityMapper::toEntity)
            .collect(Collectors.toSet()))
        .apiAccesses(domain.getApiAccesses().stream()
            .map(ApiAccessEntityMapper::toEntity)
            .collect(Collectors.toSet()))
        .build();
  }

  // ---------------------------------------------------------------------------//

  public AccessRole toDomain(AccessRoleEntity entity) {
    return AccessRole.builder()
        .id(entity.getId())
        .name(entity.getName())
        .viewAccesses(entity.getViewAccesses().stream()
            .map(ViewAccessEntityMapper::toDomain)
            .collect(Collectors.toSet()))
        .apiAccesses(entity.getApiAccesses().stream()
            .map(ApiAccessEntityMapper::toDomain)
            .collect(Collectors.toSet()))
        .build();
  }

}
