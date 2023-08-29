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

import com.app.dto.PropertyRequestDto;
import com.app.dto.PropertyResponseDto;
import com.app.dto.PropertyUpdateDto;
import com.app.service.PropertyService;

@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
    private PropertyService propertyService;

    @GetMapping
    public ResponseEntity<?> getAllProperties() {
        List<PropertyResponseDto> properties = propertyService.getAllProperties();
        return ResponseEntity.ok(properties);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPropertyById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getPropertyById(id));
    }

    @PostMapping
    public ResponseEntity<?> createProperty(@RequestBody @Valid PropertyRequestDto propertyRequestDto,
                                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors occurred.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.createProperty(propertyRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProperty(@PathVariable Long id,
                                                             @RequestBody @Valid PropertyUpdateDto propertyUpdateDto,
                                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors occurred.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(propertyService.updateProperty(id, propertyUpdateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable Long id) {
        
    	return ResponseEntity.status(HttpStatus.OK).body(propertyService.deleteProperty(id));
    }
}
