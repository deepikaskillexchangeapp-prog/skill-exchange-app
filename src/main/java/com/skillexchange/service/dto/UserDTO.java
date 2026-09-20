package com.skillexchange.service.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDTO {
	
	@NotBlank
    @Size(max = 10)
    private String username;

    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 20)
    private String lastName;

    @Min(value = 14, message = "Users below 14 years are not allowed")
    @Max(value = 120, message = "Age cannot exceed 120")
    private Integer age;

    @NotEmpty(message = "Please provide at least one skill")
    @Size(max = 10, message = "Do not provide more than 10 skills")
    private List<String> willingToTeach;

    @NotEmpty(message = "Please provide at least one skill")
    @Size(max = 10, message = "Do not provide more than 10 skills")
    private List<String> willingToLearn;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

	public UserDTO() {
		super();
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", willingToTeach=" + willingToTeach + ", willingToLearn=" + willingToLearn + ", email=" + email
				+ ", password=" + password + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
    
}
