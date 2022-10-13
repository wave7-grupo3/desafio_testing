package com.grupo03.desafio_testing.repository;

import com.grupo03.desafio_testing.model.Property;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@NoArgsConstructor
public class PropertyRepository {

    private final List<Property> properties = new ArrayList<>();

    public List<Property> createProperty(Property property) {
        properties.add(property);
        return properties;
    }

}
