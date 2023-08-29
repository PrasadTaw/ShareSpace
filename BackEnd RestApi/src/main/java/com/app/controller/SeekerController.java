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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.SeekerRequestDto;
import com.app.dto.SeekerResponseDto;
import com.app.dto.SeekerUpdateDto;
import com.app.service.SeekerService;

@RestController
@RequestMapping("/seeker")
public class SeekerController {

	@Autowired
    private SeekerService seekerService;

    @GetMapping
    public ResponseEntity<?> getAllSeekers() {
        List<SeekerResponseDto> seekers = seekerService.getAllSeekers();
        return ResponseEntity.status(HttpStatus.OK).body(seekers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSeekerById(@PathVariable Long id) {
        SeekerResponseDto seeker = seekerService.getSeekerById(id);
        if (seeker != null) {
            return ResponseEntity.ok(seeker);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createSeeker(@RequestBody @Valid SeekerRequestDto seekerRequestDto,
                                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors and return appropriate response
            return ResponseEntity.badRequest().body("Validation errors occurred.");
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(seekerService.createSeeker(seekerRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSeeker(@PathVariable Long id,
                                                          @RequestBody @Valid SeekerUpdateDto seekerUpdateDto,
                                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors and return appropriate response
            return ResponseEntity.badRequest().body("Validation errors occurred.");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(seekerService.updateSeeker(id, seekerUpdateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeeker(@PathVariable Long id) {
        
    	return ResponseEntity.status(HttpStatus.OK).body(seekerService.deleteSeeker(id));
    }

    
}
