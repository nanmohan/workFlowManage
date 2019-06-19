package com.workflow.prod.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workflow.prod.model.Role;

@Repository
public interface RoleRepository  extends CrudRepository<Role, Long>{

}
