package dev.hireben.demo.rest.permission.domain.repository;

import java.util.Collection;

import dev.hireben.demo.rest.permission.domain.entity.ApiAccess;

public interface ApiAccessRepository {

  String save(ApiAccess apiAccess);

  Collection<String> findNameById(Collection<String> ids);

}
