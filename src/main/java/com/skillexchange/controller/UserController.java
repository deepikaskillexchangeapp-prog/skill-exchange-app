package com.skillexchange.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillexchange.entity.User;
import com.skillexchange.service.UserService;
import com.skillexchange.service.dto.UpdatePasswordDto;
import com.skillexchange.service.dto.UpdateUserDTO;
import com.skillexchange.service.dto.UserDTO;

import jakarta.transaction.Transactional;
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
	
	@Transactional
	@PatchMapping("/{userName}/password")
	public ResponseEntity<String> updatePassword(@PathVariable String userName, @RequestBody UpdatePasswordDto updatePasswordDto){
		userService.updatePassword(userName, updatePasswordDto);
		return ResponseEntity.status(HttpStatus.OK).body("Password updated successfully");
	}
	
	@Transactional
	@PatchMapping("/{userName}")
	public ResponseEntity<String> updateUser(@PathVariable String userName, @RequestBody UpdateUserDTO updateUserDto){
		userService.updateUser(userName, updateUserDto);
		return ResponseEntity.status(HttpStatus.OK).body("User details updated successfully");
	}
}
