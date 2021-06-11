package mfsi.learnmvc.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mfsi.learnmvc.domain.Track;
import mfsi.learnmvc.dto.TrackDto;
import mfsi.learnmvc.repository.TrackRepository;

@Service
public class TrackService {

	@Autowired
	private TrackRepository repository;
	private List<TrackDto> tracks = new ArrayList<>();

	private Track mapper(TrackDto dto) {
		Track track = new Track();
		track.setId(dto.getId());
		track.setName(dto.getName());
		return track;
	}

	private TrackDto mapper(Track t) {
		TrackDto dto = new TrackDto();
		dto.setId(t.getId());
		dto.setName(t.getName());
		return dto;
	}

	public List<TrackDto> getAll() {
		List<Track> tracks = repository.findAll();
		List<TrackDto> dtos = new ArrayList<>();
		for (Track track : tracks) {
			dtos.add(mapper(track));
		}
		return dtos;
	}

	public TrackDto save(TrackDto dto) {
		Track track = mapper(dto);
		track = repository.save(track);
		return mapper(track);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
