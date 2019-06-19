package com.workflow.prod.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workflow.prod.model.Status;

@Repository
public interface StatusRepository  extends CrudRepository<Status, Long>{

}