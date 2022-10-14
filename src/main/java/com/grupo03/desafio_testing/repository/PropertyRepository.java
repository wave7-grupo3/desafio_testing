package com.grupo03.desafio_testing.repository;

import com.grupo03.desafio_testing.advisor.NotFoundException;
import com.grupo03.desafio_testing.model.District;
import com.grupo03.desafio_testing.model.Property;
import com.grupo03.desafio_testing.model.Room;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PropertyRepository {

    private final List<Property> properties = new ArrayList<>();

    private final List<District> districts = new ArrayList<>();

    public PropertyRepository() {
        districts.add(new District("Santa Catarina", BigDecimal.valueOf(8000)));
        districts.add(new District("Curitiba", BigDecimal.valueOf(6000)));
        districts.add(new District("Brasília", BigDecimal.valueOf(9000)));
        districts.add(new District("Belo Horizonte", BigDecimal.valueOf(5000)));
        districts.add(new District("São Paulo", BigDecimal.valueOf(10000)));
    }

    public Property createProperty(Property property) {
        List<District> listDistricts = verifyDistrictExist(property.getPropDistrict());

        if(!listDistricts.isEmpty()) {
            property.getPropDistrict().setValueDistrictM2(listDistricts.get(0).getValueDistrictM2());
            calculateTotalRoomArea(property);
            calculateTotalPropArea(property);
            calculateTotalPropPrice(property);
            properties.add(property);
            return property;
        } else {
            throw new NotFoundException("District not found!");
        }
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

    private List<District> verifyDistrictExist(District district) {
        return districts.stream()
                .filter(dist -> dist.getDistrictName().equals(district.getDistrictName()))
                .collect(Collectors.toList());
    }

    public Room getBiggestRoom(String id) {
        Room room = getAll().stream()
                .filter(prop -> prop.getId().toString().equals(id))
                .collect(Collectors.toList())
                .get(0)
                .getRooms()
                .stream().max(Comparator.comparing(Room::getTotalRoomArea)).get();

//                .map(proper -> proper.getRooms())
//                .max(Comparator.comparing(Room::getTotalRoomArea));
        return room;
    }
}