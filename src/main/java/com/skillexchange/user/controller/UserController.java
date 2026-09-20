package com.skillexchange.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillexchange.auth.dto.UserDTO;
import com.skillexchange.user.entity.User;
import com.skillexchange.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	public final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDto){
		User user = userService.createUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> deleteUser(@RequestBody UserDTO userDto){
		userService.deleteUser(userDto);
		return ResponseEntity.status(HttpStatus.OK).body("User Deleted Successfully");
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@GetMapping("/{userName}")
	public ResponseEntity<User> getUserByUserName(@PathVariable String userName){
		User user = userService.getUserByUserName(userName);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	
}
