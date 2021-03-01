package ca.charge.lab.userStation.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ca.charge.lab.station.model.service.StationEntity;
import ca.charge.lab.user.model.UserEntity;
import lombok.Data;


@Data
@Entity(name ="tb_user_station")
public class UserStationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_user_station")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_user") 
	private UserEntity user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_station") 
	private StationEntity station;
	
	
	public static class UserStationEntityBuilder {
				
		private UserStationEntity toBuild;

		UserStationEntityBuilder() {
			this.toBuild = new UserStationEntity();
		}

		UserStationEntityBuilder(UserStationEntity toBuild) {
			this.toBuild = toBuild;
		}

		public static UserStationEntityBuilder getInstance() {
			return new UserStationEntityBuilder();
		}

		public static UserStationEntityBuilder getInstance(UserStationEntity toBuild) {
			if (toBuild != null) {
				return new UserStationEntityBuilder(toBuild);
			}
			return new UserStationEntityBuilder();
		}		
		
		public UserStationEntityBuilder id(Integer id) {
			this.toBuild.id = id;
			return this;
		}
		public UserStationEntityBuilder user(UserEntity user) {
			this.toBuild.user = user;
			return this;
		}			
		
		public UserStationEntityBuilder station(StationEntity station) {
			this.toBuild.station = station;
			return this;
		}		
		
		public void setUser(UserStationEntity toBuild) {
			this.toBuild = toBuild;
		}
		
		public UserStationEntity build() {
			return this.toBuild;
		}
		
	}   

}
