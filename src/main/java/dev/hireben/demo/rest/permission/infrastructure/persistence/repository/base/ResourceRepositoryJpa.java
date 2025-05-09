package dev.hireben.demo.rest.permission.infrastructure.persistence.repository.base;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import dev.hireben.demo.rest.permission.domain.repository.base.ResourceRepository;
import dev.hireben.demo.rest.permission.infrastructure.persistence.jpa.repository.base.ResourceEntityRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class ResourceRepositoryJpa<T, D, ID, R extends ResourceEntityRepository<T, ID>>
    implements ResourceRepository<D> {

  // ---------------------------------------------------------------------------//
  // Dependencies
  // ---------------------------------------------------------------------------//

  protected final R repository;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  protected abstract String extractIdentifier(T entity);

  protected abstract T toEntity(D domain);

  protected abstract D toDomain(T entity);

  // ---------------------------------------------------------------------------//

  @Override
  public String save(D domain) {
    return extractIdentifier(repository.save(toEntity(domain)));
  }

  // ---------------------------------------------------------------------------//

  @Override
  public Optional<D> findByName(String name) {
    return repository.findByName(name).map(this::toDomain);
  }

  // ---------------------------------------------------------------------------//

  @Override
  public Set<D> findByNameIn(Collection<String> names) {
    return repository.findByNameIn(names).stream().map(this::toDomain).collect(Collectors.toSet());
  }

  // ---------------------------------------------------------------------------//

  @Override
  public boolean existsByName(String name) {
    return repository.existsByName(name);
  }

  // ---------------------------------------------------------------------------//

  @Override
  public void deleteByName(String name) {
    repository.deleteByName(name);
  }

}
