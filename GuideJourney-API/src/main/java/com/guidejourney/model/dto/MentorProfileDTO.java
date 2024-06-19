package com.guidejourney.model.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class MentorProfileDTO {

    @Email(message = "El correo electrónico debe ser válido")
    @NotNull(message = "El correo electrónico es requerido")
    private String email;

    @NotNull(message = "El nombre es requerido")
    private String name;

    @NotNull(message = "El país es requerido")
    private String country;

    private String company; // Este no necesita traducción

    @Min(value = 0, message = "Los años de experiencia deben ser un número positivo")
    private int yearsOfExperience;

    @Size(max = 1000, message = "La biografía no debe exceder los 1000 caracteres")
    private String biography;

    private String linkedinLink; // Este no necesita traducción
}
