package mfsi.learnmvc.dto;

import java.io.Serializable;
import java.util.Set;

import mfsi.learnmvc.domain.Track;

public class AlbumDto implements Serializable {

	private static final long serialVersionUID = -2632252449894727697L;

	private Integer id;

	private String name;

	private Set<IdName> tracks;

	public AlbumDto() {
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
