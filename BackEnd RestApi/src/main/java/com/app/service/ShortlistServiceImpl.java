package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.ShortlistRequestDto;
import com.app.dto.ShortlistResponseDto;
import com.app.entities.Property;
import com.app.entities.Seeker;
import com.app.entities.Shortlist;
import com.app.repo.PropertyRepository;
import com.app.repo.SeekerRepository;
import com.app.repo.ShortlistRepository;

@Service
@Transactional
public class ShortlistServiceImpl implements ShortlistService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private SeekerRepository seekerRepo;

	@Autowired
	private PropertyRepository propertyRepo;

	@Autowired
	private ShortlistRepository shortlistRepo;

	@Override
	public List<ShortlistResponseDto> getAllShortlists() {

		List<ShortlistResponseDto> dtos = new ArrayList<>();
		
		
		shortlistRepo.findAll().forEach((v) -> {
			System.out.println(v);
			ShortlistResponseDto dto = new ShortlistResponseDto();
			dto.setId(v.getId());
			dto.setPropertyId(v.getProperty().getId());
			dto.setSeekerId(v.getSeeker().getId());
			dtos.add(dto);
		});

		return dtos;

	}

	@Override
	public ShortlistResponseDto getShortlistById(Long id) {
		Shortlist shortlist = shortlistRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Such shortlist found"));
		ShortlistResponseDto dto = mapper.map(shortlist, ShortlistResponseDto.class);
		dto.setSeekerId(shortlist.getSeeker().getId());
		dto.setPropertyId(shortlist.getProperty().getId());
		return dto;

	}

	@Override
	public ApiResponse createShortlist(ShortlistRequestDto shortlistDto) {
		Seeker seeker = seekerRepo.findById(shortlistDto.getSeekerId())
				.orElseThrow(() -> new ResourceNotFoundException("No seeker record found"));
		Property property = propertyRepo.findById(shortlistDto.getPropertyId())
				.orElseThrow(() -> new ResourceNotFoundException("No property record found"));
		Shortlist shortlist = new Shortlist(seeker, property);
		shortlistRepo.save(shortlist);

		return new ApiResponse("Shortlist added successfully");

	}

	

	

	@Override
	public ApiResponse deleteShortlist(Long id) {
		Shortlist shortlist = shortlistRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No shortlist record found"));
		shortlistRepo.delete(shortlist);

		return new ApiResponse("Shortlist deleted successfully");

	}
}
