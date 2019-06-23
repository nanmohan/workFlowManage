package com.workflow.prod.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.prod.model.User;
import com.workflow.prod.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(int userId) {
		User obj = userRepository.findById((long) userId).get();
		return obj;
	}

	public Iterable<User> findAllUser() {
		return userRepository.findAll();
	}

	public User updateUser(@Valid User user) {
		return userRepository.save(user);
	}
	
}
