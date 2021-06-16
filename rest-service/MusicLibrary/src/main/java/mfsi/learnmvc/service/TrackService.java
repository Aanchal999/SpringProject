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
import mfsi.learnmvc.dto.IdName;
import mfsi.learnmvc.dto.TrackDto;
import mfsi.learnmvc.repository.AlbumRepository;
import mfsi.learnmvc.repository.PlaylistRepository;
import mfsi.learnmvc.repository.SingerRepository;
import mfsi.learnmvc.repository.TrackRepository;

@Service
public class TrackService {

	@Autowired
	private TrackRepository repository;
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private PlaylistRepository playlistRepository;
	
	@Autowired
	private SingerRepository singerRepository;

	private Track mapper(TrackDto dto) {
		Track track = new Track();
		track.setId(dto.getId());
		track.setName(dto.getName());
		//track.setDateOfRelease(dto.getDateOfRelease());
		track.setMediaFormat(dto.getMediaFormat());
		track.setMediaType(dto.getMediaType());
		//Album album = albumRepository.findById(dto.getAlbum().getId()).get();
		//track.setAlbum(album);
		
		//Set<Playlist> playlists = new HashSet<>();
		//for(IdName o : dto.getPlaylists()) {
		//Playlist playlist = playlistRepository.findById(o.getId()).get();
			//playlists.add(playlist);
		//}
		//track.setPlaylists(playlists);
		
		//Set<Singer> singers = new HashSet<>();
		//for(IdName o : dto.getSingers()) {
		//	Singer singer = singerRepository.findById(o.getId()).get();
		//	singers.add(singer);
		//}
		//track.setSingers(singers);
		return track;
	}

	private TrackDto mapper(Track t) {
		TrackDto dto = new TrackDto();
		dto.setId(t.getId());
		dto.setName(t.getName());
		dto.setDateOfRelease(t.getDateOfRelease());
		dto.setMediaFormat(t.getMediaFormat());
		dto.setMediaType(t.getMediaType());
//		dto.setPath(t.getPath());
//		dto.setAlbum(new IdName(t.getAlbum().getId(), t.getAlbum().getName()));
//		
//		List<IdName> playlists = new ArrayList<>();
//		for (Playlist playlist : t.getPlaylists()) {
//			playlists.add(new IdName(playlist.getId(), playlist.getName()));
//		}
//		dto.setPlaylists(playlists);
//		
//		List<IdName> singers = new ArrayList<>();
//		for(Singer singer : t.getSingers()) {
//			singers.add(new IdName(singer.getId(), singer.getName()));
//		}
//		dto.setSingers(singers);

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
