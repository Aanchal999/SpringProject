package mfsi.learnmvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.Playlist;
import mfsi.learnmvc.domain.Singer;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Integer> {
	public List<Playlist> findAll();
}
