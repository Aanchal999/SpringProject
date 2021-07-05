package mfsi.learnmvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mfsi.learnmvc.dto.PageInfoDto;
import mfsi.learnmvc.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService service;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> response = new ResponseEntity<>(service.getAll(), HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/selector", method = RequestMethod.GET)
	public ResponseEntity<?> selector() {
		ResponseEntity<?> response = new ResponseEntity<>(service.selector(), HttpStatus.OK);
		return response;
	}
	

}
