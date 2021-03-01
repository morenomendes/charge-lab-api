package ca.charge.lab.station.model.service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import lombok.Data;

@Data
public class Station {

	   private Integer id;
		@NotBlank
	   private String name;
		@NotBlank
	   private String location;
		@NotNull
	   private String avaliability;
		@Email
		@NotBlank
	   private String details;
	   


		public static class StationBuilder {
							
			
			private Station toBuild;

			StationBuilder() {
				this.toBuild = new Station();
			}

			StationBuilder(Station toBuild) {
				this.toBuild = toBuild;
			}

			public static StationBuilder getInstance() {
				return new StationBuilder();
			}

			public static StationBuilder getInstance(Station toBuild) {
				if (toBuild != null) {
					return new StationBuilder(toBuild);
				}
				return new StationBuilder();
			}	
			
			
			public StationBuilder id(Integer id) {
				this.toBuild.id = id;
				return this;
			}
				
			public StationBuilder name(String name) {
				this.toBuild.name = name;
				return this;
			}
			
			public StationBuilder location(String location) {
				this.toBuild.location = location;
				return this;
			}
			
			public StationBuilder avaliability(String avaliability) {
				this.toBuild.avaliability = avaliability;
				return this;
			}
			
			public StationBuilder details(String details) {
				this.toBuild.details = details;
				return this;
			}		
			public void setStation(Station toBuild) {
				this.toBuild = toBuild;
			}
			
			public Station build() {
				return this.toBuild;
			}

	
			
		}   
}