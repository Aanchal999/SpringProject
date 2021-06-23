package mfsi.learnmvc.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Album extends BaseEntity {

	@OneToMany(mappedBy = "album")
	private Set<Track> tracks;

	public Album() {
		super();
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Track> track) {
		this.tracks = track;
	}

	@Override
	public String toString() {
		return "Album [track=" + tracks + "]";
	}

}
