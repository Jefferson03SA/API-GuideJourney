package com.guidejourney.controllers;

import com.guidejourney.model.dto.MentorProfileDTO;
import com.guidejourney.services.MentorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mentors")
public class MentorProfileController {

    @Autowired
    private MentorProfileService mentorProfileService;

    @PutMapping("/profile")
    public ResponseEntity<MentorProfileDTO> updateMentorProfile(@Valid @RequestBody MentorProfileDTO mentorProfileDTO) {
        MentorProfileDTO updatedProfile = mentorProfileService.updateMentorProfile(mentorProfileDTO);
        return ResponseEntity.ok(updatedProfile);
    }
}
