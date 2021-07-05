package mfsi.learnmvc.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mfsi.learnmvc.auth.ERole;
import mfsi.learnmvc.domain.Role;
import mfsi.learnmvc.domain.Singer;
import mfsi.learnmvc.domain.User;
import mfsi.learnmvc.dto.IdName;
import mfsi.learnmvc.dto.SingerDto;
import mfsi.learnmvc.dto.UserDto;
import mfsi.learnmvc.repository.RoleRepository;
import mfsi.learnmvc.repository.UserRepository;
import mfsi.learnmvc.util.AppConstant;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Value("${security.default.admin.name}")
	private String name;

	@Value("${security.default.admin.email}")
	private String email;

	@Value("${security.default.admin.username}")
	private String username;

	@Value("${security.default.admin.password}")
	private String password;

	@Value("${security.default.admin.phone}")
	private String phoneNo;

	public void createAdminIfNotExists() {
		if (existsByRole(ERole.APPLICATION_ADMIN.role())) {
			return;
		}
		User admin = new User(username, email, encoder.encode(password));
		admin.setName(name);
		admin.setPhoneNo(phoneNo);
		admin.setCreatedBy(AppConstant.SYSTEM);
		admin.setUpdatedBy(AppConstant.SYSTEM);
		Set<Role> roles = roleRepository.findAll();
		admin.setRoles(roles);
		repository.save(admin);
	}

	public UserDto create(UserDto dto) {
		User user = mapper(dto);
		if (user.getId() == null) {
			user = repository.save(user);
		} else {
			User userDB = repository.findById(user.getId()).orElseThrow(() -> new RuntimeException("Invalid UserId."));
			userDB.setName(user.getName());
			userDB.setEmail(user.getEmail());
			userDB.setUsername(user.getUsername());
			userDB.setPassword(user.getPassword());
			userDB.setPhoneNo(user.getPhoneNo());
			user = repository.save(userDB);
		}
		return mapper(user);
	}

	public List<UserDto> getAll() {
		List<User> users = repository.findAll();
		List<UserDto> dtos = new ArrayList<>();
		for (User user : users) {
			dtos.add(mapper(user));
		}
		return dtos;
	}

	public void deleteById(Long id) {
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

	private User mapper(UserDto dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPhoneNo(dto.getPhoneNo());

		Set<Role> roles = new HashSet<>();
		for (IdName o : dto.getRoles()) {
			Optional<Role> roleOptional = roleRepository.findById(o.getId());
			if (roleOptional.isPresent()) {
				roles.add(roleOptional.get());
			}
		}
		if (roles.isEmpty()) {
			throw new RuntimeException(
					"Either no roles are associated with this users or provided roles were unavailable.");
		}
		user.setRoles(roles);
		return user;
	}

	private UserDto mapper(User u) {
		UserDto dto = new UserDto();
		dto.setId(u.getId());
		dto.setName(u.getName());
		dto.setEmail(u.getEmail());
		dto.setPhoneNo(u.getPhoneNo());

		Set<IdName> roles = new HashSet<>();
		for (Role role : u.getRoles()) {
			roles.add(new IdName(role.getId(), role.getName()));
		}
		dto.setRoles(roles);

		return dto;
	}

	public UserDto save(UserDto dto) {
		User user = mapper(dto);
		if (dto.getId() == null) { // Means this value is not in table
			user = repository.save(user);
		} else { // Means this value might be in table
			Optional<User> userOptional = repository.findById(user.getId());
			if (userOptional.isPresent()) { // Make sure value exist in table
				User userDB = userOptional.get();
				userDB.setName(user.getName());
				userDB.setRoles(user.getRoles());
				user = repository.save(userDB);
			}
		}
		return mapper(user);
	}

}
