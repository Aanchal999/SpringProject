package mfsi.learnmvc.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.Role;
import mfsi.learnmvc.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public List<User> findAll();

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	@Query("SELECT count(u) > 0 FROM User u, IN (u.roles) r WHERE r IN :roles")
	public boolean existsByAnyRole(@Param("roles") Set<Role> roles);

}
