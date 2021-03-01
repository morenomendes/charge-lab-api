package ca.charge.lab.station.model.service;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ca.charge.lab.userStation.model.UserStationEntity;
import lombok.Data;

@Data
@Entity(name = "tb_station")
public class StationEntity {

	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_station")
	 private Integer id;
	 private String name;
	 private String location;
	 private String avaliability;
	 private String details;
	   
	 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "station", orphanRemoval = true)
	 private Set<UserStationEntity> userStations;
		   

	public static class StationEntityBuilder {
					
			private StationEntity toBuild;

			StationEntityBuilder() {
				this.toBuild = new StationEntity();
			}

			StationEntityBuilder(StationEntity toBuild) {
				this.toBuild = toBuild;
			}

			public static StationEntityBuilder getInstance() {
				return new StationEntityBuilder();
			}

			public static StationEntityBuilder getInstance(StationEntity toBuild) {
				if (toBuild != null) {
					return new StationEntityBuilder(toBuild);
				}
				return new StationEntityBuilder();
			}		
			
			public StationEntityBuilder id(Integer id) {
				this.toBuild.id = id;
				return this;
			}
				
			public StationEntityBuilder name(String name) {
				this.toBuild.name = name;
				return this;
			}
			
			public StationEntityBuilder location(String location) {
				this.toBuild.location = location;
				return this;
			}
			
			public StationEntityBuilder userStations(Set<UserStationEntity> userStations) {
				this.toBuild.userStations = userStations;
				return this;
			}
			
			public StationEntityBuilder avaliability(String avaliability) {
				this.toBuild.avaliability = avaliability;
				return this;
			}
			
			public StationEntityBuilder details(String details) {
				this.toBuild.details = details;
				return this;
			}		
			public void setStationEntity(StationEntity toBuild) {
				this.toBuild = toBuild;
			}
			
			public StationEntity build() {
				return this.toBuild;
			}

	
			
		}   
}