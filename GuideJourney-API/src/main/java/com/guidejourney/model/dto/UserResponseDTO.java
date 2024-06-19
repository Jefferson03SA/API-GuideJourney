package com.guidejourney.model.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String email;
    private String role;
}