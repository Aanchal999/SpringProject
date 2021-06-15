package mfsi.learnmvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {
	
}
