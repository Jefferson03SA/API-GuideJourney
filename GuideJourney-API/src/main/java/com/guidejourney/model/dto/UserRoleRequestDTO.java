package com.guidejourney.model.dto;

import lombok.Data;

@Data
public class UserRoleRequestDTO {
    private String email;
    private String role;
}