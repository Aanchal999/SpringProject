package mfsi.learnmvc.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.Role;
import mfsi.learnmvc.dto.IdName;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	public Set<Role> findAll();

	public Optional<Role> findByName(String name);

	public boolean existsByName(String name);

	@Query("SELECT new mfsi.learnmvc.dto.IdName(id , name) FROM Role o")
	public List<IdName> getAll();
}
