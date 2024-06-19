package com.guidejourney.model.dto;

import com.guidejourney.model.enums.Country;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentProfileDTO {
    
    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico debe ser válido")
    private String email;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String name;

    @NotNull(message = "El país es obligatorio")
    private Country country;

    @NotBlank(message = "La compañía o escuela es obligatoria")
    @Size(max = 100, message = "La compañía o escuela no debe exceder los 100 caracteres")
    private String companyOrSchool;

    @NotBlank(message = "La biografía es obligatoria")
    @Size(max = 1000, message = "La biografía no debe exceder los 1000 caracteres")
    private String biography;
}