package com.morningbasket.user.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.morningbasket.user.dto.UserDto;
import com.morningbasket.user.entity.User;
import com.morningbasket.user.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	
	public ResponseEntity<User> addUser(UserDto userdto) {
		
	User user = new User();
	
	BeanUtils.copyProperties(userdto, user);
	
	if(user.getUserId() == null) {
		User entity = repo.save(user);
		
		return new ResponseEntity<>(entity,HttpStatus.CREATED);
		
	}
	    return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		
	}
	
	
	public ResponseEntity<User> fecthUserDataById(Integer userId){
		
		Optional<User> user = repo.findById(userId);
		
		if(user.isPresent()) {
			
			return new ResponseEntity<>(user.get(),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}

}
