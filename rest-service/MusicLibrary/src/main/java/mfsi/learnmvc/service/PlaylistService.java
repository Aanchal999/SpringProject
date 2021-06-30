package mfsi.learnmvc.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mfsi.learnmvc.domain.Album;
import mfsi.learnmvc.domain.Playlist;
import mfsi.learnmvc.domain.Singer;
import mfsi.learnmvc.domain.Track;
import mfsi.learnmvc.domain.User;
import mfsi.learnmvc.dto.IdName;
import mfsi.learnmvc.dto.PlaylistDto;
import mfsi.learnmvc.dto.SingerDto;
import mfsi.learnmvc.repository.AlbumRepository;
import mfsi.learnmvc.repository.PlaylistRepository;
import mfsi.learnmvc.repository.TrackRepository;
import mfsi.learnmvc.repository.UserRepository;

@Service
public class PlaylistService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TrackRepository trackRepository;
	
	@Autowired
	private PlaylistRepository repository;
	
	private Playlist mapper(PlaylistDto dto) {
		Playlist playlist = new Playlist();
		playlist.setId(dto.getId());
		playlist.setName(dto.getName());
//		User user = userRepository.findById(dto.getId()).get();
//	    playlist.setUser(user);
//		
//		Set<Track> tracks = new HashSet<>();
//		for (IdName o : dto.getTracks()) {
//			Track track = repository.findById(o.getId()).get();
//			tracks.add(track);
//		}
//		playlist.setTracks(tracks);
		return playlist;
	}
	
	private PlaylistDto mapper(Playlist p) {
		PlaylistDto dto = new PlaylistDto();
		dto.setId(p.getId());
		dto.setName(p.getName());
//		dto.setUser(new IdName(p.getUser().getId(), p.getUser().getName()));
//		
//		Set<IdName> tracks = new HashSet<>();
//		for (Track track : p.getTracks()) {
//			tracks.add(new IdName(track.getId(), track.getName()));
//		}
//		dto.setTracks(tracks);

		return dto;
	}
	
	public List<PlaylistDto> getAll() {
		List<Playlist> playlists = repository.findAll();
		List<PlaylistDto> dtos = new ArrayList<>();
		for (Playlist playlist : playlists) {
			dtos.add(mapper(playlist));
		}
		return dtos;
	}

	public PlaylistDto save(PlaylistDto dto) {
		Playlist playlist = mapper(dto);
		playlist = repository.save(playlist);
		return mapper(playlist);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public List<IdName> selector() {
		return repository.selector();
	
	}
}
