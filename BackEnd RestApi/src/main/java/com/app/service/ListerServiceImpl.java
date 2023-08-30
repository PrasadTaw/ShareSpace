package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.ListerRequestDto;
import com.app.dto.ListerResponseDto;
import com.app.dto.ListerUpdateDto;
import com.app.entities.Lister;
import com.app.repo.ListerRepository;

@Service
@Transactional
public class ListerServiceImpl implements ListerService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ListerRepository listerRepo;

	@Override
	public List<ListerResponseDto> getAllListers() {

		List<ListerResponseDto> dto = new ArrayList<>();
		listerRepo.findAll().forEach((v) -> {
			System.out.println(v);
			dto.add(mapper.map(v, ListerResponseDto.class));
		});

		return dto;

	}

	@Override
	public ListerResponseDto getListerById(Long id) {
		Lister lister = listerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Such user found"));
		ListerResponseDto dto = mapper.map(lister, ListerResponseDto.class);
		return dto;

	}

	@Override
	public ApiResponse createLister(ListerRequestDto listerDto) {
		Lister lister = mapper.map(listerDto, Lister.class);
		listerRepo.save(lister);

		return new ApiResponse("Lister added successfully");

	}

	@Override
	public ApiResponse updateLister(Long id, ListerUpdateDto updatedListerDto) {
		Lister lister = listerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Lister record found"));
		lister.setFirstName(updatedListerDto.getFirstName());
		lister.setLastName(updatedListerDto.getLastName());
		lister.setEmail(updatedListerDto.getEmail());
		lister.setPassword(updatedListerDto.getPassword());
		lister.setContact(updatedListerDto.getContact());

		listerRepo.save(lister);

		return new ApiResponse("Lister details updated");

	}

	@Override
	public ApiResponse deleteLister(Long id) {

		Lister lister = listerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No lister record found"));
		listerRepo.delete(lister);

		return new ApiResponse("Lister deleted successfully");

	}
}
