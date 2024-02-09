package com.survey.controller;

import java.util.List;
import org.apache.catalina.users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.bean.Login;
import com.survey.bean.Users;
import com.survey.service.UserService;


@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:4200/")
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping("/register")
	public String performRegisterUser(@RequestBody Users user) {
		service.registerUser(user);
		return "Registered Successfully";
	}
      
	@PutMapping("/update/{userId}")
	public ResponseEntity<String > performUpdateUser(@RequestBody Users user) {
		service.UpdateUser(user);
		return
		ResponseEntity.ok ("Updated Successfully");
	}
	
	@RequestMapping("/login")
	public ResponseEntity<?> performLogin(@RequestBody Users user) {
		Login res=service.login(user);
			return ResponseEntity.ok(res);
	}

	@DeleteMapping("/deleteUser/{userId}")
	public String performDeleteUser(@PathVariable("userId") long userId) throws Exception {
		service.deleteUser(userId);
		return "User Deleted Succefully";
	}
	
	@GetMapping("/getUserDetail/{userId}")
	public Users performGetUserById(@PathVariable("userId") Long userId) throws Exception{
		Users user = service.getUserById(userId);
		return user;
	}

	@GetMapping("/getAllUserDetails")
	public List<Users> performGetAllUsers() {
		List<Users> list = service.getAllUsers();
		return list;
	}
	
	@GetMapping("/getAllCandidates")
	public List<Users> performGetAllCandidates() {
		List<Users> list = service.getAllCandidates();
		return list;
	}
}
