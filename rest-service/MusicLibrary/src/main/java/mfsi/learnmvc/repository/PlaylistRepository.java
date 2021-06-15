package mfsi.learnmvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.Playlist;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Integer> {

}
