package com.grupo03.desafio_testing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class District {

    private UUID id = UUID.randomUUID();
    private String districtName;
    private BigDecimal valueDistrictM2;
}
