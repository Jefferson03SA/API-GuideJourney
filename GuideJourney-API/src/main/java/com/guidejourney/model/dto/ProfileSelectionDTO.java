package com.guidejourney.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProfileSelectionDTO {
    @NotBlank
    private String email;

    @NotBlank
    private String profileType; 
}