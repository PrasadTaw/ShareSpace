package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.MatchesRequestDto;
import com.app.dto.MatchesResponseDto;
import com.app.service.MatchesService;

@RestController
@RequestMapping("/matches")
public class MatchesController {

	@Autowired
    private MatchesService matchesService;
	
	@GetMapping
    public ResponseEntity<?> getAllMatches() {
        
		return ResponseEntity.status(HttpStatus.OK).body(matchesService.getAllMatches());
    }

    @PostMapping
    public ResponseEntity<?> createMatches(@RequestBody @Valid MatchesRequestDto matchesRequestDto,
                                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors occurred.");
        }

        
        return ResponseEntity.status(HttpStatus.CREATED).body(matchesService.createMatches(matchesRequestDto));
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMatchesById(@PathVariable Long id) {
        
    	return ResponseEntity.status(HttpStatus.OK).body(matchesService.getMatchesById(id));
    }

//    @GetMapping("/seeker/{seekerId}")
//    public ResponseEntity<List<MatchesResponseDto>> getSeekerMatches(@PathVariable Long seekerId) {
//        List<MatchesResponseDto> matches = matchesService.getSeekerMatches(seekerId);
//        return ResponseEntity.ok(matches);
//    }
//
//    @GetMapping("/lister/{listerId}")
//    public ResponseEntity<List<MatchesResponseDto>> getListerMatches(@PathVariable Long listerId) {
//        List<MatchesResponseDto> matches = matchesService.getListerMatches(listerId);
//        return ResponseEntity.ok(matches);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMatches(@PathVariable Long id) {
        
    	return ResponseEntity.status(HttpStatus.OK).body(matchesService.deleteMatches(id));
    }
}
