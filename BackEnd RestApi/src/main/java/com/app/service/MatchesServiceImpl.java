package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.MatchesRequestDto;
import com.app.dto.MatchesResponseDto;
import com.app.dto.MatchesUpdateDto;
import com.app.entities.Lister;
import com.app.entities.Matches;
import com.app.entities.Property;
import com.app.entities.Seeker;
import com.app.repo.ListerRepository;
import com.app.repo.MatchesRepository;
import com.app.repo.PropertyRepository;
import com.app.repo.SeekerRepository;

@Service
@Transactional
public class MatchesServiceImpl implements MatchesService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ListerRepository listerRepo;

	@Autowired
	private SeekerRepository seekerRepo;

	@Autowired
	private PropertyRepository propertyRepo;

	@Autowired
	private MatchesRepository matchesRepo;

	@Override
	public List<MatchesResponseDto> getAllMatches() {

		List<MatchesResponseDto> dto = new ArrayList<>();
		matchesRepo.findAll().forEach((v) -> {
			System.out.println(v);
			MatchesResponseDto mrd = new MatchesResponseDto();
			mrd.setId(v.getId());
			mrd.setListerId(v.getLister().getId());
			mrd.setSeekerId(v.getSeeker().getId());
			mrd.setPropertyId(v.getProperty().getId());
			dto.add(mrd);
		});

		return dto;

	}

	@Override
	public MatchesResponseDto getMatchesById(Long id) {
		Matches matches = matchesRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Such matches found"));
		MatchesResponseDto mrd = mapper.map(matches, MatchesResponseDto.class);
		mrd.setListerId(matches.getLister().getId());
		mrd.setSeekerId(matches.getSeeker().getId());
		mrd.setPropertyId(matches.getProperty().getId());
		return mrd;

	}

	@Override
	public ApiResponse createMatches(MatchesRequestDto matchesDto) {

		Lister lister = listerRepo.findById(matchesDto.getListerId())
				.orElseThrow(() -> new ResourceNotFoundException("No Lister record found"));
		Seeker seeker = seekerRepo.findById(matchesDto.getSeekerId())
				.orElseThrow(() -> new ResourceNotFoundException("No Seeker record found"));
		Property property = propertyRepo.findById(matchesDto.getPropertyId())
				.orElseThrow(() -> new ResourceNotFoundException("No Property record found"));

		Matches matches = new Matches(lister, seeker, property);
		matchesRepo.save(matches);

		return new ApiResponse("Match record saved successfully");
	}

	

	@Override
	public ApiResponse deleteMatches(Long id) {
		Matches matches = matchesRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No matches record found"));
		matchesRepo.delete(matches);

		return new ApiResponse("Matches deleted successfully");

	}
}
