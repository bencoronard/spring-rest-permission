package dev.hireben.demo.rest.permission.domain.repository;

import java.util.Collection;

import dev.hireben.demo.rest.permission.domain.entity.AccessPermission;

public interface AccessPermissionRepository {

  AccessPermission save(AccessPermission permission);

  Collection<String> findDistinctViewIdByRoleId(String roleId); // render navigation list items

  Collection<String> findApiIdByRoleIdAndViewId(String roleId, String viewId); // authorize protected view access

  boolean existsByRoleIdAndApiId(String roleId, String apiId); // authorize api access

}
