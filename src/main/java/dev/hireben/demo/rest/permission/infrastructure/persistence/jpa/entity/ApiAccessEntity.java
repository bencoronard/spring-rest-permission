package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.base.ResourceAccessEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@Table(name = "api_accesses", schema = "public")
public class ApiAccessEntity extends ResourceAccessEntity {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  @Default
  @ManyToMany(mappedBy = "linkedApis", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  private Set<ViewAccessEntity> linkedViews = new HashSet<>();

}
