package ca.charge.lab.session.repository;


import org.springframework.data.repository.CrudRepository;

import ca.charge.lab.session.model.SessionEntity;

public interface SessionRepository extends CrudRepository<SessionEntity, Integer>{
	

}
