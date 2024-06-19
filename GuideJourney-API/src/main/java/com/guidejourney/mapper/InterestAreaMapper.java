package com.guidejourney.mapper;

import com.guidejourney.model.dto.InterestAreaDTO;
import com.guidejourney.model.entities.StudentProfile;
import com.guidejourney.model.entities.MentorProfile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InterestAreaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public InterestAreaDTO toDto(StudentProfile studentProfile) {
        return modelMapper.map(studentProfile, InterestAreaDTO.class);
    }

    public InterestAreaDTO toDto(MentorProfile mentorProfile) {
        return modelMapper.map(mentorProfile, InterestAreaDTO.class);
    }

    public void updateStudentProfileFromDto(InterestAreaDTO interestAreaDTO, StudentProfile studentProfile) {
        studentProfile.setInterestAreas(interestAreaDTO.getInterestAreas());
    }

    public void updateMentorProfileFromDto(InterestAreaDTO interestAreaDTO, MentorProfile mentorProfile) {
        mentorProfile.setInterestAreas(interestAreaDTO.getInterestAreas());
    }
}

