package com.skillexchange.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillexchange.auth.dto.UpdatePasswordDto;
import com.skillexchange.auth.dto.UpdateUserDTO;
import com.skillexchange.auth.dto.UserDTO;
import com.skillexchange.exceptions.InvalidPasswordException;
import com.skillexchange.exceptions.UserNotFoundException;
import com.skillexchange.user.entity.User;
import com.skillexchange.user.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	public final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User createUser(UserDTO userDto) {
		User user = new User();
		
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setAge(userDto.getAge());
		user.setWillingToLearn(userDto.getWillingToLearn());
		user.setWillingToTeach(userDto.getWillingToTeach());
			
		return userRepository.save(user);
	}
	
	@Transactional
	public void deleteUser(UserDTO userDto) {
		String userName = userDto.getUsername();
		String password = userDto.getPassword();
		Optional<User> user = userRepository.findByUserName(userName);
		if(user.isPresent()) {
			String originalPassword = user.get().getPassword();
			if(password.equals(originalPassword)) {
				userRepository.deleteByUserName(userName);
			}
			else {
				throw new InvalidPasswordException("Cannot delete the user due to incorrect password");
			}
		}
		else {
			throw new UserNotFoundException("User not found with username: " + userName);
		}
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserByUserName(String userName) {
		Optional<User> user = userRepository.findByUserName(userName);
		
		if(user.isPresent()) {
			return user.get();
		}
		else {
			throw new UserNotFoundException("User not found with username: " + userName);
		}
	}
	
	@Transactional
	public void updatePassword(String userName, UpdatePasswordDto updatePasswordDto) {
		Optional<User> user = userRepository.findByUserName(userName);	
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found with username: " + userName);
		}
		String originalPassword = user.get().getPassword();
		String oldPassword = updatePasswordDto.getOldPassword();
		String newPassword = updatePasswordDto.getNewPassword();
		if(!oldPassword.equals(originalPassword)) {
			throw new InvalidPasswordException("Cannot update due to incorrect password");
		}
		user.get().setPassword(newPassword);
		userRepository.save(user.get());
	}
	
	@Transactional
	public void updateUser(String userName, UpdateUserDTO updateUserDto) {
		Optional<User> user = userRepository.findByUserName(userName);	
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found with username: " + userName);
		}
		String password = updateUserDto.getPassword();
		if(password == null) {
			throw new UserNotFoundException("Please enter the password");
		}
		String originalPassword = user.get().getPassword();
		if(!password.equals(originalPassword)) {
			throw new InvalidPasswordException("Cannot update user due to incorrect password");
		}
		
		if(updateUserDto.getAge() != null) {
			user.get().setAge(updateUserDto.getAge());
		}
		
		if(updateUserDto.getEmail() != null) {
			user.get().setEmail(updateUserDto.getEmail());
		}
		
		if(updateUserDto.getFirstName() != null) {
			user.get().setFirstName(updateUserDto.getFirstName());
		}
		
		if(updateUserDto.getLastName() != null) {
			user.get().setLastName(updateUserDto.getLastName());
		}
		
		if(updateUserDto.getUsername() != null) {
			user.get().setUsername(updateUserDto.getUsername());
		}
		
		if(updateUserDto.getWillingToLearn() != null) {
			user.get().setWillingToLearn(updateUserDto.getWillingToLearn());
		}
		
		if(updateUserDto.getWillingToTeach() != null) {
			user.get().setWillingToTeach(updateUserDto.getWillingToTeach());
		}
		
		userRepository.save(user.get());
	}
	
}
