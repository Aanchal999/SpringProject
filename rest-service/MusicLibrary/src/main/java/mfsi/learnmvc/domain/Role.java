package mfsi.learnmvc.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Role extends BaseEntity {

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<User> users;

	public Role() {
		super();
	}

	public Role(String name) {
		super.setName(name);
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [users=" + users + "]";
	}

}
