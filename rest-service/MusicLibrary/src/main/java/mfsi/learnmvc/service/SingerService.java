package mfsi.learnmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mfsi.learnmvc.domain.Singer;
import mfsi.learnmvc.dto.IdName;
import mfsi.learnmvc.dto.SingerDto;
import mfsi.learnmvc.repository.SingerRepository;
import mfsi.learnmvc.repository.TrackRepository;

@Service
public class SingerService {

	@Autowired
	private TrackRepository trackRepository;

	@Autowired
	private SingerRepository repository;

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
		List<Singer> singers = repository.findAll();
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
			singer = repository.save(singer);
		} else { // Means this value might be in table
			Optional<Singer> singerOptional = repository.findById(singer.getId());
			if (singerOptional.isPresent()) { // Make sure value exist in table
				Singer singerDB = singerOptional.get();
				singerDB.setName(singer.getName());
				singerDB.setGender(singer.getGender());
				singerDB.setNationality(singer.getNationality());
				singer = repository.save(singerDB);
			}
		}
		return mapper(singer);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public List<SingerDto> search(String keyword) {
		if (keyword == null || keyword.isEmpty()) {
			return getAll();
		}

		List<Singer> singers = repository.search(keyword);
		List<SingerDto> dtos = new ArrayList<>();
		for (Singer singer : singers) {
			dtos.add(mapper(singer));
		}
		return dtos;
	}

	public List<IdName> getSinger() {
		List<Singer> singers = repository.findAll();
		
		return null ;
	}

}