package ca.charge.lab.user.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ca.charge.lab.user.model.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{
	
    @Transactional
    @Modifying
    @Query(value = "UPDATE tb_user set first_name =:firstName, last_name =:lastName , phone_number =:phoneNumber , email =:email where id = :id",
            nativeQuery = true)
    	void updateUser(
    			@Param("firstName") String firstName,
    			@Param("lastName") String lastName,
    			@Param("phoneNumber") String phoneNumber,
    			@Param("email") String email,
    			@Param("id") Integer id);

}
