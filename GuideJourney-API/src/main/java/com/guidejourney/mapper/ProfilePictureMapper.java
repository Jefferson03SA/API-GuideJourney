package com.guidejourney.mapper;


import com.guidejourney.model.dto.ProfilePictureDTO;
import com.guidejourney.model.entities.MentorProfile;
import com.guidejourney.model.entities.StudentProfile;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ProfilePictureMapper {

    public void updateProfilePicture(StudentProfile studentProfile, ProfilePictureDTO profilePictureDTO) throws IOException {
        studentProfile.setProfilePicture(profilePictureDTO.getProfilePicture().getBytes());
    }

    public void updateProfilePicture(MentorProfile mentorProfile, ProfilePictureDTO profilePictureDTO) throws IOException {
        mentorProfile.setProfilePicture(profilePictureDTO.getProfilePicture().getBytes());
    }
}