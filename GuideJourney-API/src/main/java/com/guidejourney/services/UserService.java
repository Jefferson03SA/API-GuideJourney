package com.guidejourney.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guidejourney.exceptions.InvalidProfileTypeException;
import com.guidejourney.exceptions.UserNotFoundException;
import com.guidejourney.model.entities.User;
import com.guidejourney.model.enums.Role;
import com.guidejourney.repositories.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User updateUserRole(String email, String role) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        if (!user.getRole().equals(Role.PENDING)) {
            throw new InvalidProfileTypeException("No se puede cambiar la función a menos que el usuario esté en estado PENDIENTE");
        }

        try {
            Role newRole = Role.valueOf(role.toUpperCase());
            if (newRole != Role.ESTUDIANTE && newRole != Role.MENTOR) {
                throw new InvalidProfileTypeException("Tipo de rol inválido");
            }
            user.setRole(newRole);
            return userRepository.save(user);  
        } catch (IllegalArgumentException e) {
            throw new InvalidProfileTypeException("Tipo de rol invalido");
        }
    }
}