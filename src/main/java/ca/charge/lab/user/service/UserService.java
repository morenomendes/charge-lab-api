package ca.charge.lab.user.service;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.charge.lab.user.model.User;
import ca.charge.lab.user.model.User.UserBuilder;
import ca.charge.lab.user.model.UserEntity.UserEntityBuilder;
import ca.charge.lab.user.repository.UserRepository;
import ca.charge.lab.userStation.model.UserStation;
import ca.charge.lab.userStation.service.UserStationService;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserStationService userStationService;
	

	public User findById(@NotNull Integer id) {
				
		return UserBuilder
				.getInstance(userRepository.findById(id).get())
				.id(id)
				.stations(userStationService.findByUserId(UserEntityBuilder.getInstance()
						.id(id)
						.build()))
				.build();
	}
	
	public User update(User model) {
		
		userRepository.updateUser(
				model.getFirstName(),
				model.getLastName(),
				model.getPhoneNumber(),
				model.getEmail(),
				model.getId());
		
		return findById(model.getId());
	}

	public User toggleUserStation(UserStation model) {
		
		userStationService.toggleUserStation(model);
				
		return findById(model.getUser());
	}
	
	
}
