package mfsi.learnmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.Playlist;
import mfsi.learnmvc.dto.IdName;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
	public List<Playlist> findAll();

	@Query("SELECT new mfsi.learnmvc.dto.IdName(id , name) FROM Playlist o")
	public List<IdName> selector();
}
