package com.morningbasket.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.morningbasket.user.dto.UserDto;
import com.morningbasket.user.entity.User;
import com.morningbasket.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping("/get")
	public String welcome() {
		String msg = "Hello everybody";
		return msg;
	}
	
	@GetMapping("/getname")
	public String sayhello() {
		String msg = "Hello surya";
		return msg;
	}

	
    @PostMapping("/adduserdata")
	public ResponseEntity<User> addUser(@RequestBody UserDto userdto){
		
		 return service.addUser(userdto);
		
	}
    
    @GetMapping("/getuserdatabyid/{userId}")
    public ResponseEntity<User> fecthUserDataById(@PathVariable Integer userId){
    	
    	return service.fecthUserDataById(userId);
    }

}
