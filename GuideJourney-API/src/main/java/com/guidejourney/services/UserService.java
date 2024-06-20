package com.guidejourney.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.guidejourney.exceptions.UserAlreadyExistsException;
import com.guidejourney.mapper.UserMapper;
import com.guidejourney.model.dto.UserDTO;
import com.guidejourney.model.entities.User;
import com.guidejourney.model.enums.Role;
import com.guidejourney.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    public User registerUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new UserAlreadyExistsException("El correo está en uso");
        }

        User user = userMapper.convertToEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.PENDING);

        return userRepository.save(user);
    }
}