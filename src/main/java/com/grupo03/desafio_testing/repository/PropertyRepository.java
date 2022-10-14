package com.grupo03.desafio_testing.repository;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.grupo03.desafio_testing.model.Property;
import com.grupo03.desafio_testing.model.Room;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
@NoArgsConstructor
public class PropertyRepository {

    private final List<Property> properties = new ArrayList<>();

    public Property createProperty(Property property) {
        calculateTotalRoomArea(property);
        calculateTotalPropArea(property);
        calculateTotalPropPrice(property);
        properties.add(property);
        return property;
    }

    public List<Property> getAll() {
        return properties;
    }

    private void calculateTotalRoomArea(Property property) {
       property.getRooms().forEach(room -> room.setTotalRoomArea(room.getRoomWidth() * room.getRoomLength()));
    }

    private void calculateTotalPropArea(Property property) {
        Double total = property.getRooms().stream()
                .map(Room::getTotalRoomArea)
                .reduce(0.0, Double::sum);
        property.setTotalPropArea(total);
    }

    private void calculateTotalPropPrice(Property property) {
        BigDecimal totalPrice = BigDecimal.valueOf(property.getTotalPropArea()).multiply(property.getPropDistrict().getValueDistrictM2());
        property.setTotalPropPrice(totalPrice);
    }
}
