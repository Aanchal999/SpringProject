package mfsi.learnmvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.Album;
import mfsi.learnmvc.domain.Singer;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {
	public List<Album> findAll();
}
