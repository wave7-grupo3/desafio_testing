package com.grupo03.desafio_testing.services;

import com.grupo03.desafio_testing.model.District;
import com.grupo03.desafio_testing.model.Property;
import com.grupo03.desafio_testing.model.Room;
import com.grupo03.desafio_testing.repository.PropertyRepository;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {

    @InjectMocks
    private PropertyService propertyService;

    @Mock
    private PropertyRepository propertyRepository;

    private Property propertyResponse;
    private District district;
    private List<Room> rooms = new ArrayList<>();

    @BeforeEach
    void setup() {
        district = new District("Curitiba", BigDecimal.valueOf(6000.0));
        rooms.add(new Room("Quarto", 10.0, 3.0, 30.0));
        rooms.add(new Room("Sala", 8.0, 3.0, 24.0));
        rooms.add(new Room("Cozinha", 7.0, 2.0, 14.0));

        propertyResponse = new Property(UUID.randomUUID(),
                "Casa 08",
                district,
                rooms,
                68.0,
                BigDecimal.valueOf(408000.0)
        );
    }

    @Test
    @DisplayName("Validates the creation of a new property.")
    void createProperty_returnSuccess_whenValidData() {
        Mockito.when(propertyRepository.createProperty(ArgumentMatchers.any()))
                .thenReturn(propertyResponse);

        Property property = propertyService.createProperty(propertyResponse);

        assertThat(property).isNotNull();
        assertThat(property.getTotalPropArea()).isEqualTo(propertyResponse.getTotalPropArea());
        assertThat(property.getPropDistrict()).isEqualTo(propertyResponse.getPropDistrict());
        assertThat(property.getRooms()).isEqualTo(propertyResponse.getRooms());
        assertThat(property.getTotalPropPrice()).isEqualTo(propertyResponse.getTotalPropPrice());
    }

    @Test
    void getAll() {
    }

    @Test
    void getBiggestRoom() {
    }
}

//        propertyResponse = propertyResponse.builder()
//                .propName("Casa 08")
//                .propDistrict(district)
//                .rooms(rooms)
//                .totalPropArea(68.0)
//                .totalPropPrice(BigDecimal.valueOf(408000.0))
//                .build();