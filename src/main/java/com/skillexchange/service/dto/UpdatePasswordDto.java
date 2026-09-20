package com.skillexchange.service.dto;

import jakarta.validation.constraints.NotBlank;

public class UpdatePasswordDto {

	@NotBlank
	private String oldPassword;
	
	@NotBlank
	private String newPassword;

	@Override
	public String toString() {
		return "UpdatePasswordDto [oldPassword=" + oldPassword + ", newPassword=" + newPassword + "]";
	}

	public UpdatePasswordDto() {
		super();
	}

	public UpdatePasswordDto(@NotBlank String oldPassword, @NotBlank String newPassword) {
		super();
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
}
