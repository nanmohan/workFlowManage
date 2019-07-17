package com.workflow.prod.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.workflow.prod.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	  @Transactional(timeout = 10)
	  @Override
	  <S extends User> S save(S s);
	  
	/*
	 * @Transactional
	 * 
	 * @Modifying(clearAutomatically = true)
	 * 
	 * @Query("UPDATE Task t SET t.status_id=:statusId where t.task_id=:taskId") int
	 * updateStatus(@Param("statusId") Long statusId, @Param("taskId") Long taskId);
	 */

}
