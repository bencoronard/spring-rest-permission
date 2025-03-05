package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.model;

import java.io.Serializable;

import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.AccessRoleEntity;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.ApiAccessEntity;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.ViewAccessEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AccessPermissionEntityId implements Serializable {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_permission_role"))
  private AccessRoleEntity role;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "view_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_permission_view"))
  private ViewAccessEntity view;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "api_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_permission_api"))
  private ApiAccessEntity api;

}
