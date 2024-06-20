package com.guidejourney.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.guidejourney.mapper.UserMapper;
import com.guidejourney.model.dto.UserDTO;
import com.guidejourney.model.dto.UserResponseDTO;
import com.guidejourney.model.entities.User;
import com.guidejourney.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/users")
@Api(tags = "Gestión de Usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    @ApiOperation(value = "Registrar un nuevo usuario", notes = "Proporcione correo electrónico y contraseña para registrar un nuevo usuario")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.registerUser(userDTO);
        UserResponseDTO responseDTO = userMapper.convertToResponseDto(user);
        return ResponseEntity.ok(responseDTO);
    }
}