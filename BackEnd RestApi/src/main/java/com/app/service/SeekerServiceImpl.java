package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.SeekerRequestDto;
import com.app.dto.SeekerResponseDto;
import com.app.dto.SeekerUpdateDto;
import com.app.entities.Seeker;
import com.app.repo.SeekerRepository;

@Service
@Transactional
public class SeekerServiceImpl implements SeekerService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private SeekerRepository seekerRepo;

	@Override
	public List<SeekerResponseDto> getAllSeekers() {

		List<SeekerResponseDto> dto = new ArrayList<>();
		seekerRepo.findAll().forEach((v) -> {
			System.out.println(v);
			dto.add(mapper.map(v, SeekerResponseDto.class));
		});

		return dto;

	}

	@Override
	public SeekerResponseDto getSeekerById(Long id) {
		
		Seeker seeker = seekerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Such user found"));
		SeekerResponseDto dto = mapper.map(seeker, SeekerResponseDto.class);
		return dto;
	}

	@Override
	public ApiResponse createSeeker(SeekerRequestDto seekerDto) {
		Seeker seeker = mapper.map(seekerDto, Seeker.class);
		seekerRepo.save(seeker);
		
		return new ApiResponse("Seeker added successfully");
	}

	@Override
	public ApiResponse updateSeeker(Long id, SeekerUpdateDto updatedSeekerDto) {
		Seeker seeker = seekerRepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("No Seeker record found"));
		seeker.setFirstName(updatedSeekerDto.getFirstName());
		seeker.setLastName(updatedSeekerDto.getLastName());
		seeker.setEmail(updatedSeekerDto.getEmail());
		seeker.setPassword(updatedSeekerDto.getPassword());
		seeker.setContact(updatedSeekerDto.getContact());
		seekerRepo.save(seeker);
		
		return new ApiResponse("Seeker details updated");
	}

	@Override
	public ApiResponse deleteSeeker(Long id) {
		
		Seeker seeker = seekerRepo.findById(id)
						.orElseThrow(()-> new ResourceNotFoundException("No seeker record found"));
		seekerRepo.delete(seeker);
		
		return new ApiResponse("Seeker deleted successfully");
	}
	
	

}
