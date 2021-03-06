package mfsi.learnmvc.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Singer extends BaseEntity {

	private String gender;

	private String nationality;

	@ManyToMany
	@JoinTable(name = "singer_track_mapping", joinColumns = @JoinColumn(name = "singer_id"), inverseJoinColumns = @JoinColumn(name = "track_id"))
	private Set<Track> tracks;

	public Singer() {
		super();
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Singer [gender=" + gender + ", nationality=" + nationality + ", tracks=" + tracks + "]";
	}

}
