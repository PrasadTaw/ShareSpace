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

import com.app.dto.ListerRequestDto;
import com.app.dto.ListerResponseDto;
import com.app.dto.ListerUpdateDto;
import com.app.service.ListerService;

@RestController
@RequestMapping("/lister")
public class ListerController {

	@Autowired
	private ListerService listerService;

	@GetMapping
	public ResponseEntity<?> getAllListers() {
		List<ListerResponseDto> listers = listerService.getAllListers();
		return ResponseEntity.ok(listers);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getListerById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(listerService.getListerById(id));

	}

	@PostMapping
	public ResponseEntity<?> createLister(@RequestBody @Valid ListerRequestDto listerRequestDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body("Validation errors occurred.");
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(listerService.createLister(listerRequestDto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateLister(@PathVariable Long id, @RequestBody @Valid ListerUpdateDto listerUpdateDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body("Validation errors occurred.");
		}

		return ResponseEntity.status(HttpStatus.OK).body(listerService.updateLister(id, listerUpdateDto));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLister(@PathVariable Long id) {
		
		return ResponseEntity.status(HttpStatus.OK).body(listerService.deleteLister(id));
	}
}
