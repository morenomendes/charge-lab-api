package ca.charge.lab.station.service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.charge.lab.station.model.service.Station;
import ca.charge.lab.station.model.service.Station.StationBuilder;
import ca.charge.lab.station.model.service.StationEntity;
import ca.charge.lab.station.repository.StationRepository;
import ca.charge.lab.userStation.model.UserStation;

	@Service
	public class StationService {
		
		@Autowired
		private StationRepository stationRepository;

		public Station findById(@NotNull Serializable id) {
			return StationBuilder.getInstance()
					.build();
		}
		
		public Station findByUserStation(@NotNull UserStation model) {
			return StationBuilder.getInstance()
					.build();
		}
		
		public Station saveByUserStation(@NotNull UserStation model) {
			return StationBuilder.getInstance()
					.build();
		}
		
		public Station deleteByUserStation(@NotNull UserStation model) {
			return StationBuilder.getInstance()
					.build();
		}
		
		public Collection<Station> findByUserId(Integer userId) {
			Collection<Station> models = Arrays.asList(
				StationBuilder.getInstance()
									.id(1)
					                .name("Station 1")
					                .location("location 1 ")
					                .avaliability("IN-USE")
					                .details("details 1 ").build(),
				StationBuilder.getInstance()
									.id(2)
					                .name("Station 2")
					                .location("location 2 ")
					                .avaliability("IN-USE")
					                .details("details 2 ").build()					
					);
			return models;
		}
		
		public Collection<Station> findAll() {
			ModelMapper modelMapper = new ModelMapper();
			Collection<StationEntity>  stationEntitys =  (Collection<StationEntity>) stationRepository.findAll();		
			
			return stationEntitys.stream()
					.map( m -> modelMapper.map(m, Station.class))
					.collect(Collectors.toList());
		}

	}
