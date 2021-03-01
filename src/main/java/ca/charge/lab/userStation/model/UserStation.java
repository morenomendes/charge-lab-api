package ca.charge.lab.userStation.model;


import javax.validation.constraints.NotBlank;

import lombok.Data;


@Data
public class UserStation {
	@NotBlank
   private Integer id;
	@NotBlank
	   private Integer user;	
	@NotBlank
   private Integer station ;
	
	
	public static class UserStationBuilder {
				
		private UserStation toBuild;

		UserStationBuilder() {
			this.toBuild = new UserStation();
		}

		UserStationBuilder(UserStation toBuild) {
			this.toBuild = toBuild;
		}

		public static UserStationBuilder getInstance() {
			return new UserStationBuilder();
		}

		public static UserStationBuilder getInstance(UserStation toBuild) {
			if (toBuild != null) {
				return new UserStationBuilder(toBuild);
			}
			return new UserStationBuilder();
		}		
		
		
		public static UserStationBuilder getInstance(UserStationEntity entity) {
			if (entity != null) {
				return getInstance()
						.id(entity.getId())
						.user(entity.getUser().getId())
						.station(entity.getStation().getId())
						;
			}
			return new UserStationBuilder();
		}
		
		public UserStationBuilder id(Integer id) {
			this.toBuild.id = id;
			return this;
		}
		
		public UserStationBuilder user(Integer id) {
			this.toBuild.id = id;
			return this;
		}
		
		
		public UserStationBuilder station(Integer station) {
			this.toBuild.station = station;
			return this;
		}			
		
		public void setUser(UserStation toBuild) {
			this.toBuild = toBuild;
		}
		
		public UserStation build() {
			return this.toBuild;
		}
		
	}   

}
