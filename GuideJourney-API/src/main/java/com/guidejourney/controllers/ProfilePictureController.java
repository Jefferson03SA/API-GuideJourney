package com.guidejourney.controllers;

import com.guidejourney.exceptions.ProfilePictureException;
import com.guidejourney.model.dto.ProfilePictureDTO;
import com.guidejourney.services.ProfilePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/profiles")
public class ProfilePictureController {

    @Autowired
    private ProfilePictureService profilePictureService;

    @PutMapping("/students/picture")
    public ResponseEntity<String> updateStudentProfilePicture(@RequestParam String email, @RequestParam("profilePicture") MultipartFile profilePicture) {
        try {
            ProfilePictureDTO profilePictureDTO = new ProfilePictureDTO();
            profilePictureDTO.setProfilePicture(profilePicture);
            profilePictureService.updateStudentProfilePicture(email, profilePictureDTO);
            return ResponseEntity.ok("Profile picture updated successfully.");
        } catch (IOException | ProfilePictureException e) {
            return ResponseEntity.status(500).body("Error updating profile picture: " + e.getMessage());
        }
    }

    @PutMapping("/mentors/picture")
    public ResponseEntity<String> updateMentorProfilePicture(@RequestParam String email, @RequestParam("profilePicture") MultipartFile profilePicture) {
        try {
            ProfilePictureDTO profilePictureDTO = new ProfilePictureDTO();
            profilePictureDTO.setProfilePicture(profilePicture);
            profilePictureService.updateMentorProfilePicture(email, profilePictureDTO);
            return ResponseEntity.ok("Profile picture updated successfully.");
        } catch (IOException | ProfilePictureException e) {
            return ResponseEntity.status(500).body("Error updating profile picture: " + e.getMessage());
        }
    }
}
