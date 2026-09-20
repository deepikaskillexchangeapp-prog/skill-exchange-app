package com.skillexchange.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

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
	
}
