package com.guidejourney.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.guidejourney.model.dto.StudentProfileDTO;
import com.guidejourney.services.StudentProfileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
@Validated
public class StudentProfileController {

    @Autowired
    private StudentProfileService studentProfileService;

    @PutMapping("/profile")
    public ResponseEntity<StudentProfileDTO> updateStudentProfile(@Valid @RequestBody StudentProfileDTO studentProfileDTO) {
        StudentProfileDTO updatedProfile = studentProfileService.updateStudentProfile(studentProfileDTO);
        return ResponseEntity.ok(updatedProfile);
    }
}