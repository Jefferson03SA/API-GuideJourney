package com.guidejourney.model.dto;

import com.guidejourney.model.entities.Profile;
import lombok.Data;

@Data
public class UserResponseDTO {
    private long userId;
    private String email;
    private Profile profile;
}
