package com.guidejourney.services;

import com.guidejourney.exceptions.UserNotFoundException;
import com.guidejourney.mapper.ProfilePictureMapper;
import com.guidejourney.exceptions.ProfilePictureException;
import com.guidejourney.model.dto.ProfilePictureDTO;
import com.guidejourney.model.entities.MentorProfile;
import com.guidejourney.model.entities.StudentProfile;
import com.guidejourney.model.entities.User;
import com.guidejourney.repositories.MentorProfileRepository;
import com.guidejourney.repositories.StudentProfileRepository;
import com.guidejourney.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.io.IOException;

@Service
public class ProfilePictureService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private MentorProfileRepository mentorProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfilePictureMapper profilePictureMapper;

    @Transactional
    public void updateStudentProfilePicture(String email, ProfilePictureDTO profilePictureDTO) throws IOException, ProfilePictureException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        StudentProfile studentProfile = studentProfileRepository.findByUserId(user.getId())
                .orElseGet(() -> {
                    StudentProfile newProfile = new StudentProfile();
                    newProfile.setUser(user);
                    return newProfile;
                });

        try {
            profilePictureMapper.updateProfilePicture(studentProfile, profilePictureDTO);
        } catch (IOException e) {
            throw new ProfilePictureException("Error al procesar la imagen: " + e.getMessage());
        }

        studentProfileRepository.save(studentProfile);
    }

    @Transactional
    public void updateMentorProfilePicture(String email, ProfilePictureDTO profilePictureDTO) throws IOException, ProfilePictureException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        MentorProfile mentorProfile = mentorProfileRepository.findByUserId(user.getId())
                .orElseGet(() -> {
                    MentorProfile newProfile = new MentorProfile();
                    newProfile.setUser(user);
                    return newProfile;
                });

        try {
            profilePictureMapper.updateProfilePicture(mentorProfile, profilePictureDTO);
        } catch (IOException e) {
            throw new ProfilePictureException("Error al procesar la imagen: " + e.getMessage());
        }

        mentorProfileRepository.save(mentorProfile);
    }
}