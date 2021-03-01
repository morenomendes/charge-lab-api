package ca.charge.lab.home;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.charge.lab.user.model.User;
import ca.charge.lab.user.model.User.UserBuilder;
import ca.charge.lab.user.service.UserService;
import ca.charge.lab.userStation.model.UserStation;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private  UserService userService;
	

	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<User>  user(@NotNull @PathVariable("id") Integer id) {
		User model = userService.findById(id);
		
		if(model != null) {
			return new ResponseEntity<>(model, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	

	@ResponseBody
	public ResponseEntity<User>user() {
		User model = userService.findById(2);
		
		if(model != null) {
			return new ResponseEntity<>(model, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	@PutMapping
	@ResponseBody
	public User update(@RequestBody User model) {
		return userService.update(model);
	}	
	
	@PostMapping(value = "/toggleUserStation")
	@ResponseBody
	public User toggleUserStation(@RequestBody UserStation model) {
		return userService.toggleUserStation(model);
	}		

	
	@RequestMapping("/teste")
	public String teste() {
		return "userTest";
	}

	
}
