package com.guidejourney.model.dto;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

import com.guidejourney.model.enums.InterestArea;

@Data
public class UpdateInterestAreasDTO {
    @NotNull(message = "El email no puede estar vacío")
    private String email;

    @NotNull(message = "Las áreas de interés no pueden estar vacías")
    @Size(max = 5, message = "No se pueden seleccionar más de 5 áreas de interés")
    private List<InterestArea> interestAreas;
}
