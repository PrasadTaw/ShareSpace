package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.ShortlistRequestDto;
import com.app.dto.ShortlistResponseDto;
import com.app.dto.ShortlistUpdateDto;

public interface ShortlistService {

	List<ShortlistResponseDto> getAllShortlists();

	ShortlistResponseDto getShortlistById(Long id);

	ApiResponse createShortlist(ShortlistRequestDto shortlist);

	

	ApiResponse deleteShortlist(Long id);

}
