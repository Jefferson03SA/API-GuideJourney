package com.guidejourney.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guidejourney.mapper.StudentProfileMapper;
import com.guidejourney.model.dto.StudentProfileDTO;
import com.guidejourney.model.entities.StudentProfile;
import com.guidejourney.model.entities.User;
import com.guidejourney.repositories.StudentProfileRepository;
import com.guidejourney.repositories.UserRepository;

@Service
public class StudentProfileService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentProfileMapper studentProfileMapper;

    public StudentProfileDTO updateStudentProfile(StudentProfileDTO studentProfileDTO) {
        User user = userRepository.findByEmail(studentProfileDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        StudentProfile studentProfile = studentProfileRepository.findByUserId(user.getId());
        if (studentProfile == null) {
            studentProfile = new StudentProfile();
            studentProfile.setUser(user);
        }


        studentProfile.setName(studentProfileDTO.getName());
        studentProfile.setCountry(studentProfileDTO.getCountry());
        studentProfile.setCompanyOrSchool(studentProfileDTO.getCompanyOrSchool());
        studentProfile.setBiography(studentProfileDTO.getBiography());

        studentProfileRepository.save(studentProfile);
        return studentProfileMapper.toDto(studentProfile);
    }
}