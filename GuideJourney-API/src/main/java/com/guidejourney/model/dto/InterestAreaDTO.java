package com.guidejourney.model.dto;

import com.guidejourney.model.enums.InterestArea;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;


@Data
public class InterestAreaDTO {
    @NotNull(message = "Las áreas de interés son obligatorias")
    private List<InterestArea> interestAreas;
}
