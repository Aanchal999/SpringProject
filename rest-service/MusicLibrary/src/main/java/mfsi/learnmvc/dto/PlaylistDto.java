package mfsi.learnmvc.dto;

import java.io.Serializable;
import java.util.Set;

public class PlaylistDto implements Serializable {

	private static final long serialVersionUID = -1676020497454233617L;

	private Integer id;

	private String name;

	private IdName user;

	private Set<IdName> tracks;

	public PlaylistDto() {
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

	public IdName getUser() {
		return user;
	}

	public void setUser(IdName user) {
		this.user = user;
	}

	public Set<IdName> getTracks() {
		return tracks;
	}

	public void setTracks(Set<IdName> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "PlaylistDto [id=" + id + ", name=" + name + ", user=" + user + ", tracks=" + tracks + "]";
	}

}
