package mfsi.learnmvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
