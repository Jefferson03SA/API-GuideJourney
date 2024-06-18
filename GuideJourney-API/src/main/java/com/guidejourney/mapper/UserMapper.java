package com.guidejourney.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.guidejourney.model.dto.UserDTO;
import com.guidejourney.model.dto.UserResponseDTO;
import com.guidejourney.model.entities.User;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public UserResponseDTO convertToResponseDto(User user) {
        return modelMapper.map(user, UserResponseDTO.class);
    }
}

