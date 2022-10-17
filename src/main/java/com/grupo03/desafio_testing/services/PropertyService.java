package com.grupo03.desafio_testing.services;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.grupo03.desafio_testing.advisor.NotFoundException;
import com.grupo03.desafio_testing.model.District;
import com.grupo03.desafio_testing.model.Property;
import com.grupo03.desafio_testing.model.Room;
import com.grupo03.desafio_testing.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService implements IProperty {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Property createProperty(Property property) {
        List<District> listDistricts = verifyDistrictExist(property.getPropDistrict());

        if(!listDistricts.isEmpty()) {
            property.getPropDistrict().setValueDistrictM2(listDistricts.get(0).getValueDistrictM2());
            property.getRooms().forEach(room -> room.setTotalRoomArea(calculateTotalRoomArea(room)));
            property.setTotalPropArea(calculateTotalPropArea(property));
            property.setTotalPropPrice(calculateTotalPropPrice(property));
        } else {
            throw new NotFoundException("District not found!");
        }

        return propertyRepository.createProperty(property);
    }

    @Override
    public List<Property> getAll() {
        return propertyRepository.getAll();
    }

    @Override
    public Room getBiggestRoom(String id) {
        Property property = propertyRepository.getPropertyById(id);
        return getBiggestRoom(property.getRooms());
    }

    @Override
    public Double calculateTotalRoomArea(Room room) {
        return room.getRoomWidth() * room.getRoomLength();
    }

    @Override
    public Double calculateTotalPropArea(Property property) {
        return property.getRooms().stream()
                .map(Room::getTotalRoomArea)
                .reduce(0.0, Double::sum);
    }

    @Override
    public BigDecimal calculateTotalPropPrice(Property property) {
        return BigDecimal.valueOf(property.getTotalPropArea()).multiply(property.getPropDistrict().getValueDistrictM2());
    }

    @Override
    public List<District> verifyDistrictExist(District district) {
        List<District> districts = propertyRepository.getAllDistricts();

        return districts.stream()
                .filter(dist -> dist.getDistrictName().equals(district.getDistrictName()))
                .collect(Collectors.toList());
    }


    public Room getBiggestRoom(List<Room> rooms) {
        return rooms.stream().max(Comparator.comparing(Room::getTotalRoomArea)).get();
    }
}
