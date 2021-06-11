package mfsi.learnmvc.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Album extends BaseEntity {
	
	@Id
	private Integer id;
	
	private String name;

	@OneToMany(mappedBy = "album")
	private Set<Track> track;

	public Album() {
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

	public Set<Track> getTrack() {
		return track;
	}

	public void setTrack(Set<Track> track) {
		this.track = track;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", track=" + track + "]";
	}
	
	


}
