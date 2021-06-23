package mfsi.learnmvc.dto;

import java.io.Serializable;

public class IdName implements Serializable {

	private static final long serialVersionUID = -8271508022460523683L;

	private Long id;

	private String name;

	public IdName() {
		super();
	}

	public IdName(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "IdName [id=" + id + ", name=" + name + "]";
	}

}
