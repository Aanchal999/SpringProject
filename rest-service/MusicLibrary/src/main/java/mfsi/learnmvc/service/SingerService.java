package mfsi.learnmvc.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mfsi.learnmvc.domain.Singer;
import mfsi.learnmvc.domain.Track;
import mfsi.learnmvc.dto.IdName;
import mfsi.learnmvc.dto.SingerDto;
import mfsi.learnmvc.repository.TrackRepository;

@Service
public class SingerService {

	@Autowired
	private TrackRepository repository;

	private SingerDto mapper(Singer s) {
		SingerDto dto = new SingerDto();
		dto.setId(s.getId());
		dto.setName(s.getName());
		dto.setGender(s.getGender());
		dto.setNationality(s.getNationality());

		Set<IdName> tracks = new HashSet<>();
		for (Track track : s.getTracks()) {
			tracks.add(new IdName(track.getId(), track.getName()));
		}
		dto.setTracks(tracks);

		return dto;
	}

	private Singer mapper(SingerDto dto) {
		Singer singer = new Singer();
		singer.setId(dto.getId());
		singer.setName(dto.getName());
		singer.setGender(dto.getGender());
		singer.setNationality(dto.getNationality());

		Set<Track> tracks = new HashSet<>();
		for (IdName o : dto.getTracks()) {
			Track track = repository.findById(o.getId()).get();
			tracks.add(track);
		}
		singer.setTracks(tracks);

		return singer;
	}

}