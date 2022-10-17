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
import java.util.Optional;
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
            properties.add(property);
            return property;
    }

    public List<Property> getAll() {
        return properties;
    }

    public List<District> getAllDistricts() {
        return districts;
    }

    public Property getPropertyById(String id) {
        Optional<Property> property= getAll().stream()
                .filter(prop -> prop.getId().toString().equals(id))
                .collect(Collectors.toList()).stream().findFirst();

        return property.orElseThrow(() -> new NotFoundException("Property not found!"));
    }
}