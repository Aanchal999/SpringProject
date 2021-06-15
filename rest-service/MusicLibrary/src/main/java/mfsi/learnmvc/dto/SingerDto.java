package mfsi.learnmvc.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class SingerDto implements Serializable {

	private static final long serialVersionUID = -4748616859922964772L;

	private Integer id;

	private String name;

	private String gender;

	private String nationality;

	private Set<IdName> tracks;

	public SingerDto() {
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

	public Set<IdName> getTracks() {
		return tracks;
	}

	public void setTracks(Set<IdName> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "SingerDto [id=" + id + ", name=" + name + ", gender=" + gender + ", nationality=" + nationality
				+ ", tracks=" + tracks + "]";
	}

}
