	package com.skillexchange.user.repository;

import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillexchange.user.entity.Role;
import com.skillexchange.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	
	boolean existsByEmail(String email);
	
	Optional<User> findByUserName(String userName);
	
	void deleteByUserName(String username);
	
	boolean existsByUserName(String username);
	
	List<User> findByUserNameContaining(String keyword);
	
	List<User> findByFirstNameContaining(String keyword);
	
	List<User> findByLastNameContaining(String keyword);
	
	List<User> findByRole(Role role);
	
	long countByRole(Role role);
	
	List<User> findByAgeGreaterThan(Integer age);

	@Query("SELECT u FROM User u WHERE u.age BETWEEN :min AND :max")
	List<User> findByAgeBetween(Integer min, Integer max);
	
	List<User> findByCreatedAtAfter(LocalDateTime date);
	
	boolean existsByUserNameAndEmail(String username, String email);
	
	List<User> findByUserNameContainingOrEmailContaining(String username, String email);
	
	Page<User> findByRole(Role role, Pageable pageable);
	
}
