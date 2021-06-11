package mfsi.learnmvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mfsi.learnmvc.domain.Track;

public interface TrackRepository extends CrudRepository<Track, Integer>{
	public List<Track> findAll();
}