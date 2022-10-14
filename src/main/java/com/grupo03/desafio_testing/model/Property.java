package com.grupo03.desafio_testing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Property {

    private UUID id = UUID.randomUUID();

    @NotBlank(message = "The name of the property cannot be empty.")
    @Pattern(regexp = "^[A-ZÀ-Ú][a-zA-ZÁ-Úá-ú|ç|ñ|0-9\\s]+$", message = "The name of the property must begin with a capital capital letter.")
    @Size(max = 30, message = "The length of the name cannot exceed 30 characters")
    private String propName;

    @Valid
    private District propDistrict;

    @Valid
    @Size(min = 1)
    private List<Room> rooms;

    private Double totalPropArea;

}
