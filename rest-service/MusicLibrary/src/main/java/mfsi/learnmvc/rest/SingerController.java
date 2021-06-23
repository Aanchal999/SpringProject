package mfsi.learnmvc.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mfsi.learnmvc.dto.SingerDto;
import mfsi.learnmvc.service.SingerService;

@RestController
@RequestMapping("/singer")
public class SingerController {
	
	@Autowired
	private SingerService service;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> response = new ResponseEntity<>(service.getAll(), HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody SingerDto dto) {
		ResponseEntity<?> response = new ResponseEntity<>(service.save(dto), HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<?> search(@RequestParam String keyword ){
		ResponseEntity<?> response = new ResponseEntity<>(service.search(keyword), HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/getsinger", method = RequestMethod.GET)
	public ResponseEntity<?> getSinger(){
		ResponseEntity<?> response = new ResponseEntity<>(service.getSinger(), HttpStatus.OK);
		return response;
	}


}
