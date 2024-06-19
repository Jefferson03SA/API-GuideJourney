package com.guidejourney.services;

import com.guidejourney.exceptions.UserNotFoundException;
import com.guidejourney.mapper.MentorProfileMapper;
import com.guidejourney.model.dto.MentorProfileDTO;
import com.guidejourney.model.entities.MentorProfile;
import com.guidejourney.model.entities.User;
import com.guidejourney.model.enums.Country;
import com.guidejourney.repositories.MentorProfileRepository;
import com.guidejourney.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.Optional;
@Service
public class MentorProfileService {

    @Autowired
    private MentorProfileRepository mentorProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MentorProfileMapper mentorProfileMapper;

    @Transactional
    public MentorProfileDTO updateMentorProfile(MentorProfileDTO mentorProfileDTO) {
        Optional<User> userOptional = userRepository.findByEmail(mentorProfileDTO.getEmail());
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User not found");
        }

        User user = userOptional.get();
        Optional<MentorProfile> mentorProfileOptional = mentorProfileRepository.findByUser(user);
        MentorProfile mentorProfile;

        if (mentorProfileOptional.isPresent()) {
            mentorProfile = mentorProfileOptional.get();
        } else {
            mentorProfile = new MentorProfile();
            mentorProfile.setUser(user);
        }

        mentorProfile = mentorProfileMapper.toEntity(mentorProfileDTO);
        mentorProfile.setCountry(Country.valueOf(mentorProfileDTO.getCountry()));
        mentorProfile.setUser(user);

        MentorProfile savedProfile = mentorProfileRepository.save(mentorProfile);
        MentorProfileDTO updatedDTO = mentorProfileMapper.toDto(savedProfile);
        updatedDTO.setRole(user.getRole().name()); // Establecer el rol en el DTO

        return updatedDTO;
    }
}