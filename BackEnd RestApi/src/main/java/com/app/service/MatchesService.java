package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.MatchesRequestDto;
import com.app.dto.MatchesResponseDto;
import com.app.dto.MatchesUpdateDto;

public interface MatchesService {

	List<MatchesResponseDto> getAllMatches();

	MatchesResponseDto getMatchesById(Long id);

	ApiResponse createMatches(MatchesRequestDto matches);

	ApiResponse deleteMatches(Long id);

}
