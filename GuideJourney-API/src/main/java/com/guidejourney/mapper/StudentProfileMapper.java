package com.guidejourney.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.guidejourney.model.dto.StudentProfileDTO;
import com.guidejourney.model.entities.StudentProfile;

@Component
public class StudentProfileMapper {

    @Autowired
    private ModelMapper modelMapper;

    public StudentProfileDTO toDto(StudentProfile studentProfile) {
        StudentProfileDTO dto = modelMapper.map(studentProfile, StudentProfileDTO.class);
        dto.setEmail(studentProfile.getUser().getEmail()); // Asegurarse de mapear el email correctamente
        return dto;
    }

    public StudentProfile toEntity(StudentProfileDTO studentProfileDTO) {
        return modelMapper.map(studentProfileDTO, StudentProfile.class);
    }
}