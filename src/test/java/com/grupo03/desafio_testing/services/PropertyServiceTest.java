package com.grupo03.desafio_testing.services;

import com.grupo03.desafio_testing.advisor.NotFoundException;
import com.grupo03.desafio_testing.model.District;
import com.grupo03.desafio_testing.model.Property;
import com.grupo03.desafio_testing.model.Room;
import com.grupo03.desafio_testing.repository.PropertyRepository;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {

    @InjectMocks
    private PropertyService propertyService;

    @Mock
    private PropertyRepository propertyRepository;

    private Property propertyResponse;
    private District district;
    private Room biggestRoom;

    private District districtNonExistent;

    private List<District> districtList = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();

    private List<Property> propertyList = new ArrayList<>();

    @BeforeEach
    void setup() {
        district = new District("Curitiba", BigDecimal.valueOf(6000.0));
        districtNonExistent = new District("Rio de Janeiro", BigDecimal.valueOf(8000.0));

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

        propertyList.add(propertyResponse);
        districtList.add(district);

        biggestRoom = new Room("Quarto", 10.0, 3.0, 30.0);


    }

    @Test
    @DisplayName("Validates the creation of a new property.")
    void createProperty_returnSuccess_whenValidData() {

        Mockito.when(propertyRepository.createProperty(ArgumentMatchers.any()))
                .thenReturn(propertyResponse);

        Mockito.when(propertyRepository.getAllDistricts())
                .thenReturn(districtList);

        Property property = propertyService.createProperty(propertyResponse);
        property.getPropDistrict().setValueDistrictM2(BigDecimal.valueOf(6000));

        assertThat(property).isNotNull();
        assertThat(property.getPropDistrict()).isEqualTo(propertyResponse.getPropDistrict());
        assertThat(property.getRooms()).isEqualTo(propertyResponse.getRooms());
        assertThat(property.getPropDistrict().getValueDistrictM2()).isEqualTo(BigDecimal.valueOf(6000));
        assertThat(property.getTotalPropArea()).isEqualTo(propertyResponse.getTotalPropArea());
        assertThat(property.getTotalPropPrice()).isEqualTo(propertyResponse.getTotalPropPrice());
    }

    // TODO
    @Test
    @DisplayName("Validates throws NotFoundException in creation of a new property when District not found.")
    void createProperty_throwsNotFoundException_whenDistrictNotFound() throws NotFoundException {
        Mockito.when(propertyRepository.getAllDistricts())
                .thenReturn(Arrays.asList(districtNonExistent));

        assertThrows(NotFoundException.class, () -> propertyService.createProperty(propertyResponse));

        verify(propertyRepository, never()).createProperty(ArgumentMatchers.any());
    }

    @Test
    @DisplayName("Validates if it returns the list of all registered properties.")
    void getAll_returnSuccess_whenPropertiesListExists() {
        Mockito.when(propertyRepository.getAll())
                .thenReturn(propertyList);

        List<Property> propertiesResponse = propertyService.getAll();

        assertThat(propertiesResponse).isNotNull();
        assertThat(propertiesResponse.get(0).getTotalPropArea()).isEqualTo(propertyResponse.getTotalPropArea());
        assertThat(propertiesResponse.get(0).getRooms().get(0).getTotalRoomArea()).isEqualTo(propertyResponse.getRooms().get(0).getTotalRoomArea());
        assertThat(propertiesResponse.get(0).getRooms().get(1).getTotalRoomArea()).isEqualTo(propertyResponse.getRooms().get(1).getTotalRoomArea());
        assertThat(propertiesResponse.get(0).getRooms().get(2).getTotalRoomArea()).isEqualTo(propertyResponse.getRooms().get(2).getTotalRoomArea());
    }

    @Test
    @DisplayName("Validates that it returns the largest room correctly.")
    void getBiggestRoom_returnSuccess_whenConsultedTheProperty() {
        Mockito.when(propertyRepository.getPropertyById(ArgumentMatchers.anyString()))
                .thenReturn(propertyResponse);

        Room roomResponse = propertyService.getBiggestRoom(String.valueOf(propertyResponse.getId()));

        assertThat(roomResponse).isNotNull();
        assertThat(roomResponse).isEqualTo(biggestRoom);
        assertThat(roomResponse.getTotalRoomArea()).isEqualTo(biggestRoom.getTotalRoomArea());
        assertThat(roomResponse.getRoomName()).isEqualTo(biggestRoom.getRoomName());
    }

    @Test
    @DisplayName("Validates that it returns the correct total price of the property.")
    void calculateTotalPropPrice_returnSuccess_whenValueIsValid() {
       BigDecimal totalPropPrice = propertyService.calculateTotalPropPrice(propertyResponse);

       assertThat(totalPropPrice).isNotNull();
       assertThat(totalPropPrice).isNotNegative();
       assertThat(totalPropPrice.setScale(1)).isEqualTo(propertyResponse.getTotalPropPrice());
    }

    @Test
    @DisplayName("Validates that it returns the correct total room area.")
    void calculateTotalRoomArea_returnSuccess_whenValueIsValid() {
        Double totalRoomArea = propertyService.calculateTotalRoomArea(biggestRoom);

        assertThat(totalRoomArea).isNotNull();
        assertThat(totalRoomArea).isNotNegative();
        assertThat(totalRoomArea).isEqualTo(biggestRoom.getTotalRoomArea());
    }

    @Test
    @DisplayName("Validates that it returns the correct total property area.")
    void calculateTotalPropArea_returnSuccess_whenValueIsValid() {
        Double totalPropArea = propertyService.calculateTotalPropArea(propertyResponse);

        assertThat(totalPropArea).isNotNull();
        assertThat(totalPropArea).isNotNegative();
        assertThat(totalPropArea).isEqualTo(propertyResponse.getTotalPropArea());
    }

}