package mfsi.learnmvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.Singer;

@Repository
public interface SingerRepository extends CrudRepository<Singer, Integer>{
	

}
