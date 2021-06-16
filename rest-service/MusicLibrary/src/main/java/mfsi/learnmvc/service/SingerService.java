package mfsi.learnmvc.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mfsi.learnmvc.domain.Singer;
import mfsi.learnmvc.domain.Track;
import mfsi.learnmvc.dto.IdName;
import mfsi.learnmvc.dto.SingerDto;
import mfsi.learnmvc.repository.SingerRepository;
import mfsi.learnmvc.repository.TrackRepository;

@Service
public class SingerService {

	@Autowired
	private TrackRepository repository;
	
	@Autowired
	private SingerRepository singerRepository;

	private SingerDto mapper(Singer s) {
		SingerDto dto = new SingerDto();
		dto.setId(s.getId());
		dto.setName(s.getName());
		dto.setGender(s.getGender());
		dto.setNationality(s.getNationality());

//		Set<IdName> tracks = new HashSet<>();
//		for (Track track : s.getTracks()) {
//			tracks.add(new IdName(track.getId(), track.getName()));
//		}
//		dto.setTracks(tracks);

		return dto;
	}

	private Singer mapper(SingerDto dto) {
		Singer singer = new Singer();
		singer.setId(dto.getId());
		singer.setName(dto.getName());
		singer.setGender(dto.getGender());
		singer.setNationality(dto.getNationality());

//		Set<Track> tracks = new HashSet<>();
//		for (IdName o : dto.getTracks()) {
//			Track track = repository.findById(o.getId()).get();
//			tracks.add(track);
//		}
//		singer.setTracks(tracks);

		return singer;
	}
	public List<SingerDto> getAll() {
		List<Singer> singers = singerRepository.findAll();
		List<SingerDto> dtos = new ArrayList<>();
		for (Singer singer : singers) {
			dtos.add(mapper(singer));
		}
		return dtos;
	}

//	public SingerDto save(SingerDto dto) {
//		Singer singer = mapper(dto);
//		singer = singerRepository.save(singer);
//		return mapper(singer);
//	}
//	
	
	public SingerDto save(SingerDto dto) {
		Singer singer = mapper(dto);
		if (dto.getId() == null) { // Means this value is not in table
			singer = singerRepository.save(singer);
		} else { // Means this value might be in table
			Optional<Singer> singerOptional = singerRepository.findById(singer.getId());
			if (singerOptional.isPresent()) { // Make sure value exist in table
				Singer singerDB = singerOptional.get();
				singerDB.setName(singer.getName());
				singerDB.setGender(singer.getGender());
				singerDB.setNationality(singer.getNationality());
				singer = singerRepository.save(singerDB);		
			}
		}
		return mapper(singer);
	}
	public void delete(Integer id) {
		singerRepository.deleteById(id);
	}

}