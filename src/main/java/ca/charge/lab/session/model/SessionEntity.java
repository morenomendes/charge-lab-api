package ca.charge.lab.session.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity(name = "tb_session")
public class SessionEntity {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_session")
   private Integer id;
    private String name;
    private String location;
    private Integer chargingTime;
    private Integer powerConsumption;
    private Integer cost;
	
	
	public static class SessionEntityBuilder {
				
		private SessionEntity toBuild;

		SessionEntityBuilder() {
			this.toBuild = new SessionEntity();
		}

		SessionEntityBuilder(SessionEntity toBuild) {
			this.toBuild = toBuild;
		}

		public static SessionEntityBuilder getInstance() {
			return new SessionEntityBuilder();
		}

		public static SessionEntityBuilder getInstance(SessionEntity toBuild) {
			if (toBuild != null) {
				return new SessionEntityBuilder(toBuild);
			}
			return new SessionEntityBuilder();
		}		
		
		public SessionEntityBuilder id(Integer id) {
			this.toBuild.id = id;
			return this;
		}

		public SessionEntityBuilder name(String name) {
			this.toBuild.name = name;
			return this;
		}
		
		public SessionEntityBuilder location(String location) {
			this.toBuild.location = location;
			return this;
		}
		
		public SessionEntityBuilder chargingTime(Integer chargingTime) {
			this.toBuild.chargingTime = chargingTime;
			return this;
		}
		
		public SessionEntityBuilder powerConsumption(Integer powerConsumption) {
			this.toBuild.powerConsumption = powerConsumption;
			return this;
		}		
		
		public SessionEntityBuilder cost(Integer cost) {
			this.toBuild.cost = cost;
			return this;
		}		
		
		public void setSessionEntity(SessionEntity toBuild) {
			this.toBuild = toBuild;
		}
		
		public SessionEntity build() {
			return this.toBuild;
		}
		
	}   

}
