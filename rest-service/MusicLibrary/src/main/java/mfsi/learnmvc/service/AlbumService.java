package mfsi.learnmvc.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mfsi.learnmvc.domain.Album;
import mfsi.learnmvc.domain.Track;
import mfsi.learnmvc.dto.AlbumDto;
import mfsi.learnmvc.dto.IdName;
import mfsi.learnmvc.repository.AlbumRepository;
import mfsi.learnmvc.repository.TrackRepository;

@Service
public class AlbumService {

	@Autowired
	private TrackRepository trackRepository;

	@Autowired
	private AlbumRepository repository;

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

	private AlbumDto mapper(Album album, boolean isList) {
		AlbumDto dto = new AlbumDto();
		dto.setId(album.getId());
		dto.setName(album.getName());

		if (!isList) {
			Set<IdName> tracks = new HashSet<>();
			for (Track track : album.getTracks()) {
				tracks.add(new IdName(track.getId(), track.getName()));
			}
			dto.setTracks(tracks);
		}

		return dto;
	}

	public List<AlbumDto> getAll() {
		List<Album> albums = repository.findAll();
		List<AlbumDto> dtos = new ArrayList<>();
		for (Album album : albums) {
			dtos.add(mapper(album, true));
		}
		return dtos;
	}

	public AlbumDto save(AlbumDto dto) {
		Album album = mapper(dto);
		album = repository.save(album);
		return mapper(album, false);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public AlbumDto detail(Long id) {
		Album album = repository.findById(id).orElse(new Album());
		return mapper(album, false);
	}

	public List<IdName> selector() {
		return repository.selector();
	}

}
