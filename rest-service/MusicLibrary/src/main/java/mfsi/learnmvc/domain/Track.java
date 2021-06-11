package mfsi.learnmvc.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Track extends BaseEntity {

	@Id
	private Integer id;

	private String name;
	
	private String mediaType;
	
	private String mediaFormat;

	private Date dateOfRelease;

	private String path;

	@ManyToOne
	@JoinColumn(name = "album_id")
	private Album album;

	@ManyToMany(mappedBy = "tracks")
	private Set<Playlist> playlists;

	@ManyToMany(mappedBy = "tracks")
	private Set<Singer> singers;

	public Track() {
		super();
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

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Set<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Set<Playlist> playlists) {
		this.playlists = playlists;
	}

	public Set<Singer> getSingers() {
		return singers;
	}

	public void setSingers(Set<Singer> singers) {
		this.singers = singers;
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

	@Override
	public String toString() {
		return "Track [id=" + id + ", name=" + name + ", dateOfRelease=" + dateOfRelease + ", path=" + path + ", album="
				+ album + "]";
	}

}
