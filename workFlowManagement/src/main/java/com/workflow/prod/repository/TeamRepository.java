package com.workflow.prod.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workflow.prod.model.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long>{

}