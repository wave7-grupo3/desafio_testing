package com.grupo03.desafio_testing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class District {

    @NotBlank(message = "The name of the district cannot be empty.")
    @Size(max = 45, message = "The length of the name cannot exceed 45 characters")
    private String districtName;

    @PositiveOrZero
    @NotNull(message = "That the value of the square meter in the neighborhood cannot be empty")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 11, fraction = 2)
    private BigDecimal valueDistrictM2;
}
