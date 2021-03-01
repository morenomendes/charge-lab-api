package ca.charge.lab.station.repository;


import org.springframework.data.repository.CrudRepository;

import ca.charge.lab.station.model.service.StationEntity;

public interface StationRepository extends CrudRepository<StationEntity, Integer>{
	

}