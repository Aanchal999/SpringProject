package mfsi.learnmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mfsi.learnmvc.domain.Album;
import mfsi.learnmvc.dto.AlbumDto;
import mfsi.learnmvc.repository.AlbumRepository;
import mfsi.learnmvc.repository.TrackRepository;


@Service
public class AlbumService {
	
	@Autowired
	private TrackRepository repository;
	
	@Autowired
	private AlbumRepository albumRepository;

	private Album mapper(AlbumDto dto) {
		Album album = new Album();
		album.setId(dto.getId());
		album.setName(dto.getName());
		
//		Set<Track> tracks = new HashSet<>();
//		for (IdName o : dto.getTracks()) {
//			Track track = repository.findById(o.getId()).get();
//			tracks.add(track);
//		}
//		album.setTrack(tracks);
		
		return album;
	}
	
	private AlbumDto mapper(Album a) {
		AlbumDto dto = new AlbumDto();
		dto.setId(a.getId());
//		dto.setName(a.getName());
//		Set<IdName> tracks = new HashSet<>();
//		for (Track track : a.getTrack()) {
//			tracks.add(new IdName(track.getId(), track.getName()));
//		}
//		dto.setTracks(tracks);
		
		return dto;
	}
	
	public List<AlbumDto> getAll() {
		List<Album> albums = albumRepository.findAll();
		List<AlbumDto> dtos = new ArrayList<>();
		for (Album album : albums) {
			dtos.add(mapper(album));
		}
		return dtos;
	}

	public AlbumDto save(AlbumDto dto) {
		Album album = mapper(dto);
		album = albumRepository.save(album);
		return mapper(album);
	}

	public void delete(Long id) {
		albumRepository.deleteById(id);
	}
}
