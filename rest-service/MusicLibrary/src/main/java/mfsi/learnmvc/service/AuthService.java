package mfsi.learnmvc.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mfsi.learnmvc.auth.ERole;
import mfsi.learnmvc.auth.JwtUtil;
import mfsi.learnmvc.auth.UserDetailsImpl;
import mfsi.learnmvc.domain.Role;
import mfsi.learnmvc.domain.User;
import mfsi.learnmvc.dto.JwtDto;
import mfsi.learnmvc.dto.UserLoginDto;
import mfsi.learnmvc.dto.UserRegistrationDto;
import mfsi.learnmvc.repository.RoleRepository;
import mfsi.learnmvc.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	private PasswordEncoder encoder;

	public void register(UserRegistrationDto userRegistration) {
		User user = new User(userRegistration.getUsername(), userRegistration.getEmail(),
				encoder.encode(userRegistration.getPassword()));

		Role defaultRole = roleRepository.findByName(ERole.USER.role()).get();
		Set<Role> roles = new HashSet<>();
		roles.add(defaultRole);

		user.setRoles(roles);
		repository.save(user);
	}

	public boolean existsByUsername(String username) {
		return repository.existsByUsername(username);
	}

	public boolean existsByEmail(String email) {
		return repository.existsByEmail(email);
	}

	public JwtDto authenticate(UserLoginDto userLogin) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userLogin.getUsername(),
				userLogin.getPassword());

		Authentication authentication = authenticationManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtil.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		JwtDto jwtDto = new JwtDto(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles);

		return jwtDto;

	}

}
