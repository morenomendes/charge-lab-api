package ca.charge.lab.session.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;


@Data
public class Session {
	
   private Integer id;
	@NotBlank
    private String name;
    private String location;
    private Integer chargingTime;
    private Integer powerConsumption;
    private Integer cost;
	
	
	public static class SessionBuilder {
				
		private Session toBuild;

		SessionBuilder() {
			this.toBuild = new Session();
		}

		SessionBuilder(Session toBuild) {
			this.toBuild = toBuild;
		}

		public static SessionBuilder getInstance() {
			return new SessionBuilder();
		}

		public static SessionBuilder getInstance(Session toBuild) {
			if (toBuild != null) {
				return new SessionBuilder(toBuild);
			}
			return new SessionBuilder();
		}		
		
		public SessionBuilder id(Integer id) {
			this.toBuild.id = id;
			return this;
		}

		public SessionBuilder name(String name) {
			this.toBuild.name = name;
			return this;
		}
		
		public SessionBuilder location(String location) {
			this.toBuild.location = location;
			return this;
		}
		
		public SessionBuilder chargingTime(Integer chargingTime) {
			this.toBuild.chargingTime = chargingTime;
			return this;
		}
		
		public SessionBuilder powerConsumption(Integer powerConsumption) {
			this.toBuild.powerConsumption = powerConsumption;
			return this;
		}		
		
		public SessionBuilder cost(Integer cost) {
			this.toBuild.cost = cost;
			return this;
		}		
		
		public void setSession(Session toBuild) {
			this.toBuild = toBuild;
		}
		
		public Session build() {
			return this.toBuild;
		}
		
	}   

}
