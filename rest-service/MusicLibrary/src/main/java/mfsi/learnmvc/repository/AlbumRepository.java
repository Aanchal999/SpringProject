package mfsi.learnmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.Album;
import mfsi.learnmvc.dto.IdName;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
	public List<Album> findAll();
	
	@Query("SELECT new mfsi.learnmvc.dto.IdName(id , name) FROM Album o")
	public List<IdName> selector();
}
