package com.guidejourney.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guidejourney.exceptions.ProfileNotFoundException;
import com.guidejourney.exceptions.UserNotFoundException;
import com.guidejourney.model.dto.UpdateInterestAreasDTO;
import com.guidejourney.model.entities.StudentProfile;
import com.guidejourney.model.entities.User;
import com.guidejourney.repositories.StudentProfileRepository;
import com.guidejourney.repositories.UserRepository;

import jakarta.transaction.Transactional;
import java.util.Optional;


@Service
public class StudentProfileService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public StudentProfile updateInterestAreas(UpdateInterestAreasDTO updateInterestAreasDTO) {
        Optional<User> userOptional = userRepository.findByEmail(updateInterestAreasDTO.getEmail());
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("Usuario no encontrado");
        }

        User user = userOptional.get();
        Optional<StudentProfile> profileOptional = studentProfileRepository.findByUser(user);

        if (!profileOptional.isPresent()) {
            throw new ProfileNotFoundException("Perfil de estudiante no encontrado");
        }

        StudentProfile studentProfile = profileOptional.get();
        studentProfile.setInterestAreas(updateInterestAreasDTO.getInterestAreas());

        return studentProfileRepository.save(studentProfile);
    }
}