package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity.base.ResourceAccessEntity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@Table(name = "view_accesses", schema = "public")
public class ViewAccessEntity extends ResourceAccessEntity {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  @Default
  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "view_api_links", joinColumns = @JoinColumn(name = "view_id"), inverseJoinColumns = @JoinColumn(name = "api_id"))
  private Set<ApiAccessEntity> linkedApis = new HashSet<>();

}
