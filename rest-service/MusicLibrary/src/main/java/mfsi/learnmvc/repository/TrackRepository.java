package mfsi.learnmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.Track;

@Repository
public interface TrackRepository extends CrudRepository<Track, Long> {
	public List<Track> findAll();

	@Query("SELECT o FROM Track o WHERE o.name LIKE %:keyword% OR o.album LIKE %:keyword%")
	public List<Track> search(@Param("keyword") String keyword);

}