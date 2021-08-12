package com.asg.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	@NotNull
	private Integer id;
	
	@NotNull(message="Họ Tên không được để trống")
	@NotBlank
	private String username;

	@NotNull
	@NotBlank
	@Email
	private String email;

	@NotNull
	@NotBlank
	private String password;

	@Null
	private String photo;

	@NotNull
	private Integer admin;

	@NotNull
	private Integer activated;

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", photo=" + photo + ", admin=" + admin + ", activated=" + activated + "]";
	}
	
}