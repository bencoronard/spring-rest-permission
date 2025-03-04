package dev.hireben.demo.rest.permission.domain.repository;

import java.util.Collection;

import dev.hireben.demo.rest.permission.domain.entity.ViewAccess;

public interface ViewAccessRepository {

  String save(ViewAccess viewAccess);

  Collection<String> findNamesById(Collection<String> ids);

}
