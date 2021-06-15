package mfsi.learnmvc.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mfsi.learnmvc.domain.Role;
import mfsi.learnmvc.domain.User;
import mfsi.learnmvc.dto.IdName;
import mfsi.learnmvc.dto.UserDto;
import mfsi.learnmvc.repository.RoleRepository;

@Service
public class UserService {

	@Autowired
	private RoleRepository roleRepository;

	private User mapper(UserDto dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.seteMail(dto.geteMail());
		user.setPhoneNo(dto.getPhoneNo());

		return user;
	}

	private UserDto mapper(User u) {
		UserDto dto = new UserDto();
		dto.setId(u.getId());
		dto.setName(u.getName());
		dto.seteMail(u.geteMail());
		dto.setPhoneNo(u.getPhoneNo());

		Set<IdName> roles = new HashSet<>();
		for (Role role : u.getRoles()) {
			roles.add(new IdName(role.getId(), role.getName()));
		}
		dto.setRoles(roles);

		return dto;
	}
}
