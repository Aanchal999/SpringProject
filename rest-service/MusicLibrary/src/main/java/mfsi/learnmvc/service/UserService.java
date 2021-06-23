package mfsi.learnmvc.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mfsi.learnmvc.auth.ERole;
import mfsi.learnmvc.domain.Role;
import mfsi.learnmvc.domain.User;
import mfsi.learnmvc.dto.UserDto;
import mfsi.learnmvc.repository.RoleRepository;
import mfsi.learnmvc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepository;

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
		List<User> users = repository.findAll();
		List<UserDto> dtos = new ArrayList<>();
		for (User user : users) {
			dtos.add(mapper(user));
		}
		return dtos;
	}

	public UserDto save(UserDto dto) {
		User user = mapper(dto);
		user = repository.save(user);
		return mapper(user);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public boolean existsByRole(String roleName) {
		Role role = roleRepository.findByName(roleName).orElse(null);
		if (role != null) {
			return existsByRole(role);
		}
		return false;
	}

	public boolean existsByRole(Role role) {
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		return repository.existsByAnyRole(roles);
	}

	public void createAdminIfNotExists() {
		if (existsByRole(ERole.APPLICATION_ADMIN.role())) {
			return;
		}
		User admin = new User("admin", "admin@gmail.com", "12345678");
		admin.setName("Admin");
		admin.setUsername("admin");
		Set<Role> roles = roleRepository.findAll();
		admin.setRoles(roles);
		repository.save(admin);
	}

}
