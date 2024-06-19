package com.guidejourney.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.guidejourney.model.dto.UpdateInterestAreasDTO;
import com.guidejourney.model.entities.StudentProfile;
import com.guidejourney.services.StudentProfileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentProfileController {

    @Autowired
    private StudentProfileService studentProfileService;

    @PutMapping("/areas")
    public ResponseEntity<StudentProfile> updateInterestAreas(@Valid @RequestBody UpdateInterestAreasDTO updateInterestAreasDTO) {
        StudentProfile updatedProfile = studentProfileService.updateInterestAreas(updateInterestAreasDTO);
        return ResponseEntity.ok(updatedProfile);
    }
}