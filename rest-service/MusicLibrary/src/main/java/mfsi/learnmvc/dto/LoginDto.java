package mfsi.learnmvc.dto;

import java.io.Serializable;

public class LoginDto implements Serializable {

	private static final long serialVersionUID = 7328974526044039765L;

	private String username;

	private String email;

	private String password;

	public LoginDto() {
		super();
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

	@Override
	public String toString() {
		return "LoginDto [username=" + username + ", email=" + email + ", password=" + password + "]";
	}

}
