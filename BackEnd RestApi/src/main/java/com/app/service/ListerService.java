package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.ListerRequestDto;
import com.app.dto.ListerResponseDto;
import com.app.dto.ListerUpdateDto;

public interface ListerService {

	List<ListerResponseDto> getAllListers();

	ListerResponseDto getListerById(Long id);

	ApiResponse createLister(ListerRequestDto lister);

	ApiResponse updateLister(Long id, ListerUpdateDto updatedLister);

	ApiResponse deleteLister(Long id);

}
