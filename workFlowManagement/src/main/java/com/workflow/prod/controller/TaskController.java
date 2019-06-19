package com.workflow.prod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workflow.prod.model.Task;
import com.workflow.prod.service.TaskService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/task")
@Api(value = "TASK INFO", tags = "TASK")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping(value = "/findAll")
	public List<Task> findAll() {
		return taskService.findAll();
	}
	
	@PostMapping("/addTask")
    void addUser(@RequestBody Task task) {
		taskService.save(task);
    }

}