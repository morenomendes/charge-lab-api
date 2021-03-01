package ca.charge.lab.home;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.charge.lab.session.model.Session;
import ca.charge.lab.session.service.SessionService;

@RestController
@RequestMapping("/sessions")
public class SessionController {
	
	@Autowired
	private  SessionService sessionService;
	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public Session stations(@NotNull @PathVariable("id") Integer id) {
		return sessionService.findById(id);
	}
	

	@GetMapping
	@ResponseBody
	public ResponseEntity<Collection<Session>>stations() {
		
		Collection<Session> models = sessionService.findAll();
		
		if(models != null && !models.isEmpty()) {
			return new ResponseEntity<>(models, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}	
		
	@RequestMapping("/testeStations")
	public String teste() {
		return "testeStations";
	}

	
}
