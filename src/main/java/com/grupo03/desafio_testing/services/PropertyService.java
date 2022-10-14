package com.grupo03.desafio_testing.services;

import com.grupo03.desafio_testing.model.Property;
import com.grupo03.desafio_testing.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService implements IProperty {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Property createProperty(Property property) {
        return propertyRepository.createProperty(property);
    }

    @Override
    public List<Property> getAll() {
        return propertyRepository.getAll();
    }
}
