package com.hornung.roadiestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hornung.roadiestudio.model.User;
import com.hornung.roadiestudio.repository.Users;

@Service
public class UserService {
	
	@Autowired
	private Users users;
	
	public void save(User user){

		//TODO regras de negócio
		this.users.save(user);
	}
	
	public void delete(int codUser) {
		this.users.delete(codUser);
	}
	
	public User findBy(String username, String password) {
		return users.findByUsernameAndPassword(username, password);
	}


}
