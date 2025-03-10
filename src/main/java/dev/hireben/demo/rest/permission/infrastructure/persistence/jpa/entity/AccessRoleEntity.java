package dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
@Table(name = "roles", schema = "public")
public class AccessRoleEntity {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @ManyToMany
  @JoinTable(name = "role_view_links", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "view_id"))
  private Set<ViewAccessEntity> viewAccesses;

  @ManyToMany
  @JoinTable(name = "role_api_links", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "api_id"))
  private Set<ApiAccessEntity> apiAccesses;

}
