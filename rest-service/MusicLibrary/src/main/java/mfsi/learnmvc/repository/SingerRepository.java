package mfsi.learnmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mfsi.learnmvc.domain.Singer;

@Repository
public interface SingerRepository extends CrudRepository<Singer, Long> {

	public List<Singer> findAll();

	@Query("SELECT o FROM Singer o WHERE o.name LIKE %:keyword% OR o.gender LIKE %:keyword% OR o.nationality LIKE %:keyword%")
	public List<Singer> search(@Param("keyword") String keyword);

}
