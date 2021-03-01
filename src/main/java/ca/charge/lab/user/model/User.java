package ca.charge.lab.user.model;


import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import ca.charge.lab.station.model.service.Station;
import ca.charge.lab.userStation.model.UserStation;
import lombok.Data;


@Data
public class User {
	
   private Integer id;
	@NotBlank
   private String firstName;
	@NotBlank
   private String lastName;
	@NotNull
   private String phoneNumber;
	@Email
	@NotBlank
   private String email;
   private List<Integer> stations ;
	
	
	public static class UserBuilder {
				
		private User toBuild;

		UserBuilder() {
			this.toBuild = new User();
		}

		UserBuilder(User toBuild) {
			this.toBuild = toBuild;
		}

		public static UserBuilder getInstance() {
			return new UserBuilder();
		}

		public static UserBuilder getInstance(User toBuild) {
			if (toBuild != null) {
				return new UserBuilder(toBuild);
			}
			return new UserBuilder();
		}	
		
		public static UserBuilder getInstance(UserEntity entity) {
			if (entity != null) {
				
				entity.getUserStations().stream().map(m->m.getStation().getId());
				
				
				return new UserBuilder()
						.id(entity.getId())
						.firstName(entity.getFirstName())
						.lastName(entity.getLastName())
						.email(entity.getEmail())
						.phoneNumber(entity.getPhoneNumber())
						;
			}
			return new UserBuilder();
		}		
		
		
		public UserBuilder id(Integer id) {
			this.toBuild.id = id;
			return this;
		}
		
		public UserBuilder firstName(String firstName) {
			this.toBuild.firstName = firstName;
			return this;
		}
		
		public UserBuilder lastName(String lastName) {
			this.toBuild.lastName = lastName;
			return this;
		}
		
		public UserBuilder phoneNumber(String phoneNumber) {
			this.toBuild.phoneNumber = phoneNumber;
			return this;
		}
		
		public UserBuilder email(String email) {
			this.toBuild.email = email;
			return this;
		}		
		
		public UserBuilder userStation(Collection<UserStation> userStations) {
			if(userStations != null && !userStations.isEmpty()) {
				Collection<Station> stations =   (Collection<Station>) userStations.stream().map(m -> m.getStation());
				this.toBuild.stations = (List<Integer>) stations.stream().map(m -> m.getId());	
			}
			return this;
		}	
		
		
		public UserBuilder stations(List<Integer> stations) {
			this.toBuild.stations = stations;
			return this;
		}		
		
		public void setUser(User toBuild) {
			this.toBuild = toBuild;
		}
		
		public User build() {
			return this.toBuild;
		}
		
	}   

}
