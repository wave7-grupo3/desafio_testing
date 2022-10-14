package com.grupo03.desafio_testing.repository;

import com.grupo03.desafio_testing.model.Property;
import com.grupo03.desafio_testing.model.Room;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@NoArgsConstructor
public class PropertyRepository {

    private final List<Property> properties = new ArrayList<>();

    public Property createProperty(Property property) {
        calculateTotalRoomArea(property);
        properties.add(property);
        return property;
    }

    public List<Property> getAll() {
        return properties;
    }

    private void calculateTotalRoomArea(Property property) {
       property.getRooms().forEach(room -> {
                    room.setTotalRoomArea(room.getRoomWidth() * room.getRoomLength());
                });
    }

}
