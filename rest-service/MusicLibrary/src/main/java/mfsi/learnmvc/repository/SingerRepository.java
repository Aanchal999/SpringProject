package mfsi.learnmvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.Singer;
import mfsi.learnmvc.domain.Track;

@Repository
public interface SingerRepository extends CrudRepository<Singer, Integer>{
	public List<Singer> findAll();

}
