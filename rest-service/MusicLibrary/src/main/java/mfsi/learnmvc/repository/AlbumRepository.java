package mfsi.learnmvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
	public List<Album> findAll();
}
