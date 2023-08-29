package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListerResponseDto {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private String contact;
}
