package mfsi.learnmvc.dto;

import java.io.Serializable;
import java.util.Set;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 399152049271485999L;

	private Integer id;

	private String name;

	private String eMail;

	private String phoneNo;

	private Set<IdName> roles;

	public UserDto() {
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

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Set<IdName> getRoles() {
		return roles;
	}

	public void setRoles(Set<IdName> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", eMail=" + eMail + ", phoneNo=" + phoneNo + ", roles=" + roles
				+ "]";
	}

}
