package com.workflow.prod.controller;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workflow.prod.model.ResponseModel;
import com.workflow.prod.model.User;
import com.workflow.prod.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/user")
@Api(value = "USER INFO", tags = "USER")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping()
    public Iterable<User> findAllUser(){
        return userService.findAllUser();
    }
	
	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public ResponseModel login(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		ResponseModel responseModel = new ResponseModel();
		Iterable<User> users = userService.findAllUser();
		for(User user:users) {
			if(user.getUserName().equals(userName)) {
				if(user.getPassword().equals(password)) {
					responseModel.setStatus(200);
					responseModel.setUsers(user);
				}
				else {
					responseModel.setStatus(403);
					responseModel.setErrorMessage("Incorrect Password");
				}
			}
			else {
				responseModel.setStatus(403);
				responseModel.setErrorMessage("Incorrect Username");
			}
		}
		return responseModel;		
	}
	

	@GetMapping(path = {"/{id}"})
    public User findUser(@PathVariable("id") int id){
        return userService.getUserById(id);
    }
	
	@PutMapping()
    public ResponseEntity<Object> updateUser(@RequestBody @Valid User user){
		if(user.getUserId()==null)
		{
			Random rand = new Random(); 
			user.setUserId(rand.nextLong());			
		}
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUser(user));
    }

}
