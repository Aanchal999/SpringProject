package mfsi.learnmvc.dto;

import java.io.Serializable;
import java.util.Date;

public class TrackDto implements Serializable{
	
	private Integer id;

	private String name;
	
	private String mediaType;
	
	private String mediaFormat;

	private Date dateOfRelease;

	private String path;

	public TrackDto() {
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

	@Override
	public String toString() {
		return "TrackDto [id=" + id + ", name=" + name + ", mediaType=" + mediaType + ", mediaFormat=" + mediaFormat
				+ ", dateOfRelease=" + dateOfRelease + ", path=" + path + "]";
	}
	
	

}
