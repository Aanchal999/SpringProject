package mfsi.learnmvc.dto;

import java.io.Serializable;
import java.util.Set;

public class AlbumDto implements Serializable {

	private static final long serialVersionUID = -2632252449894727697L;

	private Long id;

	private String name;

	private Set<IdName> tracks;

	public AlbumDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<IdName> getTracks() {
		return tracks;
	}

	public void setTracks(Set<IdName> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "AlbumDto [id=" + id + ", name=" + name + ", tracks=" + tracks + "]";
	}

}
