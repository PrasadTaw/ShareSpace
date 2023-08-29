package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.SeekerRequestDto;
import com.app.dto.SeekerResponseDto;
import com.app.dto.SeekerUpdateDto;

public interface SeekerService {

	List<SeekerResponseDto> getAllSeekers();

	SeekerResponseDto getSeekerById(Long id);

	ApiResponse createSeeker(SeekerRequestDto seeker);

	ApiResponse updateSeeker(Long id, SeekerUpdateDto updatedSeeker);

	ApiResponse deleteSeeker(Long id);

}
