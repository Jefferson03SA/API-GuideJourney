package com.guidejourney.model.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProfilePictureDTO {
    private String email;
    private MultipartFile profilePicture;
}