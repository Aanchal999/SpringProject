package mfsi.learnmvc.dto;

import java.io.Serializable;

public class IdName implements Serializable {

	private static final long serialVersionUID = -8271508022460523683L;

	private Integer id;

	private String name;

	public IdName() {
		super();
	}

	public IdName(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "IdName [id=" + id + ", name=" + name + "]";
	}

}
