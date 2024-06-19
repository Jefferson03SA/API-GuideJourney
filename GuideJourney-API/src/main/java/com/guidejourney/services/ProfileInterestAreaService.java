package com.guidejourney.services;


import com.guidejourney.exceptions.UserNotFoundException;
import com.guidejourney.mapper.InterestAreaMapper;
import com.guidejourney.model.dto.InterestAreaDTO;
import com.guidejourney.model.entities.StudentProfile;
import com.guidejourney.model.entities.MentorProfile;
import com.guidejourney.model.entities.User;
import com.guidejourney.repositories.StudentProfileRepository;
import com.guidejourney.repositories.MentorProfileRepository;
import com.guidejourney.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProfileInterestAreaService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private MentorProfileRepository mentorProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InterestAreaMapper interestAreaMapper;

    @Transactional
    public InterestAreaDTO updateStudentInterestAreas(String email, InterestAreaDTO interestAreaDTO) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        StudentProfile studentProfile = studentProfileRepository.findByUserId(user.getId())
                .orElseThrow(() -> new UserNotFoundException("Perfil de estudiante no encontrado"));

        interestAreaMapper.updateStudentProfileFromDto(interestAreaDTO, studentProfile);
        studentProfileRepository.save(studentProfile);

        return interestAreaMapper.toDto(studentProfile);
    }

    @Transactional
    public InterestAreaDTO updateMentorInterestAreas(String email, InterestAreaDTO interestAreaDTO) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        MentorProfile mentorProfile = mentorProfileRepository.findByUserId(user.getId())
                .orElseThrow(() -> new UserNotFoundException("Perfil de mentor no encontrado"));

        interestAreaMapper.updateMentorProfileFromDto(interestAreaDTO, mentorProfile);
        mentorProfileRepository.save(mentorProfile);

        return interestAreaMapper.toDto(mentorProfile);
    }
}