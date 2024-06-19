package com.guidejourney.model.dto;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.*;

@Data
@ApiModel(description = "DTO para registrar un nuevo usuario")
public class UserDTO {

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico debe ser válido")
    @ApiModelProperty(value = "Dirección de correo electrónico del usuario", example = "usuario@ejemplo.com", required = true)
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @ApiModelProperty(value = "Contraseña del usuario", required = true)
    private String password;
}
