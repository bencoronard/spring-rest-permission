package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.mapper;

import java.util.stream.Collectors;

import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.ViewAccessEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ViewAccessEntityMapper {

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public ViewAccessEntity toEntity(ViewAccess domain) {
    return ViewAccessEntity.builder()
        .path(domain.getName())
        .token(domain.getToken())
        .linkedApis(domain.getLinkedApis().stream()
            .map(ApiAccessEntityMapper::toEntity)
            .collect(Collectors.toSet()))
        .build();
  }

  // ---------------------------------------------------------------------------//

  public ViewAccess toDomain(ViewAccessEntity entity) {
    return ViewAccess.builder()
        .name(entity.getPath())
        .token(entity.getToken())
        .linkedApis(entity.getLinkedApis().stream()
            .map(ApiAccessEntityMapper::toDomain)
            .collect(Collectors.toSet()))
        .build();
  }

}
