package ca.charge.lab.userStation.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.charge.lab.station.model.service.StationEntity;
import ca.charge.lab.user.model.UserEntity;
import ca.charge.lab.userStation.model.UserStationEntity;

public interface UserStationRepository extends CrudRepository<UserStationEntity, Integer>{
	
	List<UserStationEntity> findByUser(UserEntity userEntity);
	
	List<UserStationEntity> findByUserAndStation(UserEntity userEntity, StationEntity stationEntity);
	
}
