package ca.charge.lab.session.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.charge.lab.session.model.Session;
import ca.charge.lab.session.model.Session.SessionBuilder;
import ca.charge.lab.session.model.SessionEntity;
import ca.charge.lab.session.repository.SessionRepository;
import ca.charge.lab.station.model.service.Station;
import ca.charge.lab.station.model.service.StationEntity;
import ca.charge.lab.station.repository.StationRepository;


@Service
public class SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	public Session findById(Integer id) {
		return null;
	}

	public Collection<Session> findAll() {
		ModelMapper modelMapper = new ModelMapper();
		Collection<SessionEntity>  sessionEntitys =  (Collection<SessionEntity>) sessionRepository.findAll();		
		
		return sessionEntitys.stream()
				.map( m -> modelMapper.map(m, Session.class))
				.collect(Collectors.toList());
	}
	
	/*
	public Collection<Session> findAll() {
		
		return  Arrays.asList(
				SessionBuilder.getInstance()
                .id(1)
                .name("session 1")
                .location("location 1 ")
                .chargingTime(1)
                .powerConsumption(11)
                .cost(111)
                .build(),
                SessionBuilder.getInstance()
                .id(2)
                .name("session 2")
                .location("location 2 ")
                .chargingTime(2)
                .powerConsumption(22)
                .cost(222)
                .build(),
                SessionBuilder.getInstance()
                .id(3)
                .name("session 3")
                .location("location 3 ")
                .chargingTime(3)
                .powerConsumption(33)
                .cost(333)
                .build()                
					);
	}*/

	
	
	
}
