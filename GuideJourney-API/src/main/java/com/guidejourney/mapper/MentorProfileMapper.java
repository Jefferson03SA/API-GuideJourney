package com.guidejourney.mapper;

import com.guidejourney.model.dto.MentorProfileDTO;
import com.guidejourney.model.entities.MentorProfile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MentorProfileMapper {

    @Autowired
    private ModelMapper modelMapper;

    public MentorProfile toEntity(MentorProfileDTO mentorProfileDTO) {
        return modelMapper.map(mentorProfileDTO, MentorProfile.class);
    }

    public MentorProfileDTO toDto(MentorProfile mentorProfile) {
        return modelMapper.map(mentorProfile, MentorProfileDTO.class);
    }
}
