package com.workflow.prod.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workflow.prod.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{
}