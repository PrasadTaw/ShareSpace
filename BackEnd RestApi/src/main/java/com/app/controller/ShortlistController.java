package com.app.controller;

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

import com.app.dto.ShortlistRequestDto;
import com.app.dto.ShortlistResponseDto;
import com.app.service.ShortlistService;

@RestController
@RequestMapping("/shortlist")
public class ShortlistController {

	@Autowired
    private ShortlistService shortlistService;

	@GetMapping
    public ResponseEntity<?> getAllShortlists() {
        
		return ResponseEntity.status(HttpStatus.OK).body(shortlistService.getAllShortlists());
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<?> getShortlistById(@PathVariable Long id) {
        
		return ResponseEntity.status(HttpStatus.OK).body(shortlistService.getShortlistById(id));
    }
	
    @PostMapping
    public ResponseEntity<?> createShortlist(@RequestBody @Valid ShortlistRequestDto shortlistRequestDto,
                                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors occurred.");
        }

        
        return ResponseEntity.status(HttpStatus.CREATED).body(shortlistService.createShortlist(shortlistRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShortlist(@PathVariable Long id) {
        
    	return ResponseEntity.status(HttpStatus.OK).body(shortlistService.deleteShortlist(id));
    }
    
//    @GetMapping("/seeker/{seekerId}")
//    public ResponseEntity<List<ShortlistResponseDto>> getSeekerShortlists(@PathVariable Long seekerId) {
//        List<ShortlistResponseDto> shortlists = shortlistService.getSeekerShortlists(seekerId);
//        return ResponseEntity.ok(shortlists);
//    }
//
//    @GetMapping("/property/{propertyId}")
//    public ResponseEntity<List<ShortlistResponseDto>> getPropertyShortlists(@PathVariable Long propertyId) {
//        List<ShortlistResponseDto> shortlists = shortlistService.getPropertyShortlists(propertyId);
//        return ResponseEntity.ok(shortlists);
//    }

    
}
