package mfsi.learnmvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mfsi.learnmvc.dto.MessageDto;
import mfsi.learnmvc.dto.UserLoginDto;
import mfsi.learnmvc.dto.UserRegistrationDto;
import mfsi.learnmvc.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService service;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody UserLoginDto userLogin) {
		ResponseEntity<?> response = new ResponseEntity<>(service.authenticate(userLogin), HttpStatus.OK);
		return response;
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserRegistrationDto userRegistration) {
		ResponseEntity<?> response = null;

		if (service.existsByUsername(userRegistration.getUsername())) {
			return new ResponseEntity<>(new MessageDto("Error: Username is already taken!"), HttpStatus.BAD_REQUEST);
		}
		if (service.existsByEmail(userRegistration.getEmail())) {
			return new ResponseEntity<>(new MessageDto("Error: Email is already in use!"), HttpStatus.BAD_REQUEST);
		}

		service.register(userRegistration);

		response = new ResponseEntity<>(new MessageDto("User registered successfully!"), HttpStatus.OK);
		return response;
	}

}
