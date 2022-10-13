package com.grupo03.desafio_testing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Property {

    private UUID id = UUID.randomUUID();

    private String propName;

    private District propDistrict;

    private List<Room> rooms;

}
