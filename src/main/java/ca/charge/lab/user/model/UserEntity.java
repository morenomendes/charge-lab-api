package ca.charge.lab.user.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import ca.charge.lab.userStation.model.UserStationEntity;
import lombok.Data;

@Data
@Entity(name = "tb_user")
public class UserEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_user") 
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
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private Set<UserStationEntity> userStations;
	
	public static class UserEntityBuilder {
				
		private UserEntity toBuild;

		UserEntityBuilder() {
			this.toBuild = new UserEntity();
		}

		UserEntityBuilder(UserEntity toBuild) {
			this.toBuild = toBuild;
		}

		public static UserEntityBuilder getInstance() {
			return new UserEntityBuilder();
		}

		public static UserEntityBuilder getInstance(UserEntity toBuild) {
			if (toBuild != null) {
				return new UserEntityBuilder(toBuild);
			}
			return new UserEntityBuilder();
		}	
		
		public static UserEntityBuilder getInstance(User entity) {
			if (entity != null) {
				return getInstance()
						.id(entity.getId())
						.firstName(entity.getFirstName())
						.lastName(entity.getLastName())
						.email(entity.getEmail())
						.phoneNumber(entity.getPhoneNumber())
						;
			}
			return new UserEntityBuilder();
		}
		
		
		public UserEntityBuilder id(Integer id) {
			this.toBuild.id = id;
			return this;
		}
		
		public UserEntityBuilder firstName(String firstName) {
			this.toBuild.firstName = firstName;
			return this;
		}
		
		public UserEntityBuilder lastName(String lastName) {
			this.toBuild.lastName = lastName;
			return this;
		}
		
		public UserEntityBuilder phoneNumber(String phoneNumber) {
			this.toBuild.phoneNumber = phoneNumber;
			return this;
		}
		
		public UserEntityBuilder email(String email) {
			this.toBuild.email = email;
			return this;
		}		
		
		public UserEntityBuilder userStations(Set<UserStationEntity> userStations) {
			this.toBuild.userStations = userStations;
			return this;
		}	
		
		public void setUserEntity(UserEntity toBuild) {
			this.toBuild = toBuild;
		}
		
		public UserEntity build() {
			return this.toBuild;
		}
		
	}   

}
