package com.workflow.prod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.prod.model.Task;
import com.workflow.prod.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

	public List<Task> findAll() {
		return (List<Task>) taskRepository.findAll();
	}

	public void save(Task task) {
		taskRepository.save(task);
	}
	
	public void deletetask(int taskId) {
		taskRepository.delete(getTaskById(taskId));
	}

	private Task getTaskById(int taskId) {
		Task obj = taskRepository.findById((long) taskId).get();
		return obj;
	}
	
}