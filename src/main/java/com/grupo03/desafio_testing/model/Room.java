package com.grupo03.desafio_testing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @NotBlank(message = "The name of the room cannot be empty.")
    @Pattern(regexp = "^[A-ZÀ-Ú][a-zA-ZÁ-Úá-ú|ç|ñ|0-9\\s]+$", message = "The name of the room must begin with a capital capital letter.")
    @Size(max = 30, message = "The length of room name cannot exceed 30 characters")
    private String roomName;

    @NotNull
    @PositiveOrZero
    @Max(value = 25, message = "the maximum width per room is 25 meters")
    private Double roomWidth;

    @NotNull
    @PositiveOrZero
    @Max(value = 33, message = "the maximum length per room is 33 meters")
    private Double roomLength;

}
