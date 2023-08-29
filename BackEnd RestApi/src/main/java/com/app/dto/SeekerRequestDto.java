package com.app.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.app.entities.Shortlist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SeekerRequestDto {

	@NotBlank(message = "First Name cannot be blank")
	private String firstName;

	@NotBlank(message = "Last Name cannot be blank")
	private String lastName;

	@NotBlank(message = "Email Name cannot be blank")
	@Email(message = "Invalid email format")
	private String email;

	@NotBlank(message = "Password cannot be blank")
	private String password;

	@NotBlank(message = "Confirm Password cannot be blank")
	private String confirmPassword;

	@NotBlank(message = "Contact number cannot be blank")
	private String contact;

	
}
