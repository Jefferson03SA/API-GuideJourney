package com.guidejourney.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.guidejourney.model.dto.UserRoleRequestDTO;
import com.guidejourney.model.entities.User;
import com.guidejourney.services.UserService;
import com.guidejourney.model.dto.UserResponseDTO;

@RestController
@RequestMapping("/users")
public class ProfileController {

    @Autowired
    private UserService userService;

    @PostMapping("/select-role")
    public ResponseEntity<UserResponseDTO> selectUserRole(@RequestBody UserRoleRequestDTO userRoleRequest) {
        User user = userService.updateUserRole(userRoleRequest.getEmail(), userRoleRequest.getRole());
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setRole(user.getRole().toString());
        return ResponseEntity.ok(responseDTO);
    }
}