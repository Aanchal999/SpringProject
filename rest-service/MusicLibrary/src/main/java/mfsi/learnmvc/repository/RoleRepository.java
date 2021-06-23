package mfsi.learnmvc.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	public Set<Role> findAll();

	public Optional<Role> findByName(String name);

	public boolean existsByName(String name);

}
