package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.mapper;

import java.util.stream.Collectors;

import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.ApiAccessEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ApiAccessEntityMapper {

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  public ApiAccessEntity toEntity(ApiAccess domain) {
    return ApiAccessEntity.builder()
        .name(domain.getName())
        .token(domain.getToken())
        .linkedViews(domain.getLinkedViews().stream()
            .map(ViewAccessEntityMapper::toEntity)
            .collect(Collectors.toSet()))
        .build();
  }

  // ---------------------------------------------------------------------------//

  public ApiAccess toDomain(ApiAccessEntity entity) {
    return ApiAccess.builder()
        .name(entity.getName())
        .token(entity.getToken())
        .linkedViews(entity.getLinkedViews().stream()
            .map(ViewAccessEntityMapper::toDomain)
            .collect(Collectors.toSet()))
        .build();
  }

}
