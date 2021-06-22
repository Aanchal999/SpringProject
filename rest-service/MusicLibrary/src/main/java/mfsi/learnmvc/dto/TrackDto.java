package mfsi.learnmvc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import mfsi.learnmvc.domain.Playlist;
import mfsi.learnmvc.domain.Singer;
import mfsi.learnmvc.domain.Track;

public class TrackDto implements Serializable {

	private static final long serialVersionUID = -567668572996723066L;

	private Integer id;

	private String name;

	private String mediaType;

	private String mediaFormat;

	private Date dateOfRelease;

	private String path;

	private IdName album;

	private List<IdName> playlists;

	private List<IdName> singers;

	public TrackDto() {
		super();
	}

	public TrackDto(Track track) {
		id = track.getId();
		name = track.getName();
		mediaType = track.getMediaType();
		mediaFormat = track.getMediaFormat();
		dateOfRelease = track.getDateOfRelease();

		album = new IdName(track.getAlbum().getId(), track.getAlbum().getName());

		for (Playlist playlist : track.getPlaylists()) {
			playlists.add(new IdName(playlist.getId(), playlist.getName()));
		}

		for (Singer singer : track.getSingers()) {
			singers.add(new IdName(singer.getId(), singer.getName()));
		}

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getMediaFormat() {
		return mediaFormat;
	}

	public void setMediaFormat(String mediaFormat) {
		this.mediaFormat = mediaFormat;
	}

	public Date getDateOfRelease() {
		return dateOfRelease;
	}

	public void setDateOfRelease(Date dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public IdName getAlbum() {
		return album;
	}

	public void setAlbum(IdName album) {
		this.album = album;
	}

	public List<IdName> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<IdName> playlists) {
		this.playlists = playlists;
	}

	public List<IdName> getSingers() {
		return singers;
	}

	public void setSingers(List<IdName> singers) {
		this.singers = singers;
	}

	@Override
	public String toString() {
		return "TrackDto [id=" + id + ", name=" + name + ", mediaType=" + mediaType + ", mediaFormat=" + mediaFormat
				+ ", dateOfRelease=" + dateOfRelease + ", path=" + path + ", album=" + album + ", playlists="
				+ playlists + ", singers=" + singers + "]";
	}


}
