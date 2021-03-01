package ca.charge.lab.userStation.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.charge.lab.station.model.service.Station;
import ca.charge.lab.station.model.service.StationEntity;
import ca.charge.lab.station.model.service.StationEntity.StationEntityBuilder;
import ca.charge.lab.user.model.User;
import ca.charge.lab.user.model.UserEntity;
import ca.charge.lab.user.model.UserEntity.UserEntityBuilder;
import ca.charge.lab.userStation.model.UserStation;
import ca.charge.lab.userStation.model.UserStationEntity;
import ca.charge.lab.userStation.model.UserStationEntity.UserStationEntityBuilder;
import ca.charge.lab.userStation.repository.UserStationRepository;

@Service
public class UserStationService {
	
	@Autowired
	private UserStationRepository userStationRepository;
	
	public List<Integer> findByUserId(UserEntity userEntity) {
		return userStationRepository.findByUser(userEntity).stream()
				.map( m -> m.getStation().getId())
				.collect(Collectors.toList());
	}
	
	public List<Integer> findByUserIdAndStationId(UserEntity userEntity, StationEntity stationEntity) {
		return userStationRepository.findByUserAndStation(userEntity, stationEntity).stream()
				.map( m -> m.getId())
				.collect(Collectors.toList());
	}
	
	public Collection<UserStation> findAll() {
		ModelMapper modelMapper = new ModelMapper();
		Collection<UserStationEntity>  UserSessionEntitys =  (Collection<UserStationEntity>) userStationRepository.findAll();		
		
		return UserSessionEntitys.stream()
				.map( m -> modelMapper.map(m, UserStation.class))
				.collect(Collectors.toList());
	}
	
	public List<UserStation> findByUser(UserEntity userEntity) {
		ModelMapper modelMapper = new ModelMapper();	
		
		return userStationRepository.findByUser(userEntity).stream()
				.map( m -> modelMapper.map(m, UserStation.class))
				.collect(Collectors.toList());
	}	
	
	public void toggleUserStation(UserStation model) {
		
		List<Integer> favorites = findByUserIdAndStationId(
				UserEntityBuilder.getInstance().id(model.getUser()).build(),
				StationEntityBuilder.getInstance().id(model.getStation()).build());
		
		
		if(favorites == null || favorites.isEmpty()) {
			
			userStationRepository.save(
					UserStationEntityBuilder.getInstance()
					.user(UserEntityBuilder.getInstance().id(model.getUser()).build())
					.station(StationEntityBuilder.getInstance().id(model.getStation()).build())     
					.build());
			
		} else {
			
			favorites.stream().findFirst().ifPresent( i -> 
			userStationRepository.deleteById(i)
					);
			
		}
	}
	
	
}
