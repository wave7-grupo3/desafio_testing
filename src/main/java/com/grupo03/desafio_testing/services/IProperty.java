package com.grupo03.desafio_testing.services;

import com.grupo03.desafio_testing.model.Property;
import com.grupo03.desafio_testing.model.Room;

import java.util.List;

public interface IProperty {
    Property createProperty(Property property);
    List<Property> getAll();

    Room getBiggestRoom(String id);
}
