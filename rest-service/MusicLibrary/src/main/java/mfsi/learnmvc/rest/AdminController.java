package mfsi.learnmvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mfsi.learnmvc.dto.UserDto;
import mfsi.learnmvc.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@PreAuthorize("hasAuthority('APPLICATION_ADMIN')")
	@PostMapping("/user/create")
	public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
		ResponseEntity<?> response = new ResponseEntity<>(userService.create(userDto), HttpStatus.OK);
		return response;
	}

	@PreAuthorize("hasAuthority('APPLICATION_ADMIN')")
	@GetMapping("/user/all")
	public ResponseEntity<?> getUsers() {
		ResponseEntity<?> response = new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
		return response;
	}

	@PreAuthorize("hasAuthority('APPLICATION_ADMIN')")
	@DeleteMapping("/user/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteById(id);
	}

}
