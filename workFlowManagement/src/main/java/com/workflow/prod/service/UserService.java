package com.workflow.prod.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workflow.prod.model.AssignedTask;
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
	
	public User getUserByName(String userName) {
		Iterable<User> allUser = this.findAllUser();
		for(User user: allUser) {
			if(user.getUserName().equals(userName)) {
				return user;
			}
		}
		return null;		
	}

	public Iterable<User> findAllUser() {
		return userRepository.findAll();
	}

	@Transactional
	public User save(User user) {		
		return userRepository.save(user);
	}
	
}
