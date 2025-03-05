package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity;

import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.model.AccessPermissionEntityId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "permissions", schema = "public", indexes = {
    @Index(name = "idx_role_id", columnList = "role_id"),
    @Index(name = "idx_view_id", columnList = "view_id"),
    @Index(name = "idx_api_id", columnList = "api_id")
})
public class AccessPermissionEntity {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  @EmbeddedId
  private AccessPermissionEntityId id;

}
