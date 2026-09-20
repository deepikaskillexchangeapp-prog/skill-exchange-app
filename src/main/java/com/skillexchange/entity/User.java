package com.skillexchange.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 10, unique = true)
	private String userName;
	
	@Column(length = 50)
	private String firstName;
	
	@Column(length = 20)
	private String lastName;
	
	@Column
	@Min(value = 14, message = "Users below 14 years are not allowed")
	@Max(value = 120, message = "Age cannot exceed 120")
	private Integer age;
	
	@ElementCollection
	@Size(max = 10, message = "Do not provide more than 10 skills")
	private List<String> willingToTeach;
	
	@ElementCollection
	@Size(max = 10, message = "Do not provide more than 10 skills")
	private List<String> willingToLearn;
	
	@Email
	@Column(length = 50)
	private String email;
	
	@Column(length = 255)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Role role = Role.ROLE_GUEST;
	
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	public User() {
		super();
	}

	public User(Long id, String username, String firstName, String lastName,
			@Min(value = 14, message = "Users below 14 years are not allowed") @Max(value = 120, message = "Age cannot exceed 120") Integer age,
			@Size(min = 1, message = "Please provide atleast one skill") @Size(max = 10, message = "Do not provide more than 10 skills") List<String> willingToTeach,
			@Size(min = 1, message = "Please provide atleast one skill") @Size(max = 10, message = "Do not provide more than 10 skills") List<String> willingToLearn,
			@Email String email, String password, Role role, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.userName = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.willingToTeach = willingToTeach;
		this.willingToLearn = willingToLearn;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<String> getWillingToTeach() {
		return willingToTeach;
	}

	public void setWillingToTeach(List<String> willingToTeach) {
		this.willingToTeach = willingToTeach;
	}

	public List<String> getWillingToLearn() {
		return willingToLearn;
	}

	public void setWillingToLearn(List<String> willingToLearn) {
		this.willingToLearn = willingToLearn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
}