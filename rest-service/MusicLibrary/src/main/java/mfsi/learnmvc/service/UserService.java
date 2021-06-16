package mfsi.learnmvc.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mfsi.learnmvc.domain.Role;
import mfsi.learnmvc.domain.Track;
import mfsi.learnmvc.domain.User;
import mfsi.learnmvc.dto.IdName;
import mfsi.learnmvc.dto.TrackDto;
import mfsi.learnmvc.dto.UserDto;
import mfsi.learnmvc.repository.RoleRepository;
import mfsi.learnmvc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;

	private User mapper(UserDto dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setEmail(dto.geteMail());
		user.setPhoneNo(dto.getPhoneNo());

		return user;
	}

	private UserDto mapper(User u) {
		UserDto dto = new UserDto();
		dto.setId(u.getId());
		dto.setName(u.getName());
		dto.seteMail(u.getEmail());
		dto.setPhoneNo(u.getPhoneNo());

//		Set<IdName> roles = new HashSet<>();
//		for (Role role : u.getRoles()) {
//			roles.add(new IdName(role.getId(), role.getName()));
//		}
//		dto.setRoles(roles);

		return dto;
	}
	public List<UserDto> getAll() {
		List<User> users = userRepository.findAll();
		List<UserDto> dtos = new ArrayList<>();
		for (User user : users) {
			dtos.add(mapper(user));
		}
		return dtos;
	}

	public UserDto save(UserDto dto) {
		User user = mapper(dto);
		user = userRepository.save(user);
		return mapper(user);
	}

	public void delete(Integer id) {
		userRepository.deleteById(id);
	}
	
}
