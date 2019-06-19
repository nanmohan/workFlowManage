package com.workflow.prod.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workflow.prod.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
