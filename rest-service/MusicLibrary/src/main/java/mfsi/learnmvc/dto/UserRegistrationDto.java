package mfsi.learnmvc.dto;

import java.io.Serializable;

public class UserRegistrationDto implements Serializable {

	private static final long serialVersionUID = 7729141582300609141L;

	private String name;

	private String username;

	private String email;

	private String password;

	private String phoneNo;

	public UserRegistrationDto() {
		super();
	}

	public UserRegistrationDto(String name, String username, String email, String password, String phoneNo) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "UserRegistrationDto [name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + ", phoneNo=" + phoneNo + "]";
	}

}
