package com.grupo03.desafio_testing.services;

import com.grupo03.desafio_testing.model.District;
import com.grupo03.desafio_testing.model.Property;
import com.grupo03.desafio_testing.model.Room;

import java.math.BigDecimal;
import java.util.List;

public interface IProperty {
    Property createProperty(Property property);
    List<Property> getAll();
    Room getBiggestRoom(String id);
    Double calculateTotalRoomArea(Room room);
    Double calculateTotalPropArea(Property property);
    BigDecimal calculateTotalPropPrice(Property property);
    List<District> verifyDistrictExist(District district);
    Room findBiggestRoom(List<Room> rooms);
}
