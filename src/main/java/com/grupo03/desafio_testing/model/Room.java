package com.grupo03.desafio_testing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    private String roomName;
    private Double roomWidth;
    private Double roomLength;

}
