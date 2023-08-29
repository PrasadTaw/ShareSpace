package com.app.dto;

import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListerUpdateDto {

	private String firstName;

	private String lastName;

	@Email(message = "Invalid email format")
	private String email;

	private String password;

	private String contact;
}
