package com.guidejourney.controllers;

import com.guidejourney.model.dto.InterestAreaDTO;
import com.guidejourney.services.ProfileInterestAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/profiles")
public class ProfileInterestAreaController {

    @Autowired
    private ProfileInterestAreaService profileInterestAreaService;

    @PutMapping("/students/areas")
    public ResponseEntity<InterestAreaDTO> updateStudentInterestAreas(@RequestParam String email, @Valid @RequestBody InterestAreaDTO interestAreaDTO) {
        InterestAreaDTO updatedInterestAreas = profileInterestAreaService.updateStudentInterestAreas(email, interestAreaDTO);
        return ResponseEntity.ok(updatedInterestAreas);
    }

    @PutMapping("/mentors/areas")
    public ResponseEntity<InterestAreaDTO> updateMentorInterestAreas(@RequestParam String email, @Valid @RequestBody InterestAreaDTO interestAreaDTO) {
        InterestAreaDTO updatedInterestAreas = profileInterestAreaService.updateMentorInterestAreas(email, interestAreaDTO);
        return ResponseEntity.ok(updatedInterestAreas);
    }
}
