package com.workflow.prod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workflow.prod.model.User;
import com.workflow.prod.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/user")
@Api(value = "USER INFO", tags = "USER")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = {"/{id}"})
    public User findUser(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

}
