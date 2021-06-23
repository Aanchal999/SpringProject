package mfsi.learnmvc.auth;

public enum ERole {

	APPLICATION_ADMIN("APPLICATION_ADMIN"), MUSIC_ADMIN("MUSIC_ADMIN"), USER("USER");

	private String role;

	private ERole(String role) {
		this.role = role;
	}

	public String role() {
		return role;
	}

	@Override
	public String toString() {
		return role;
	}

}
