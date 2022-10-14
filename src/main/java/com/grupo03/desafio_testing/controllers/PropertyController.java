package com.grupo03.desafio_testing.controllers;

import com.grupo03.desafio_testing.model.Property;
import com.grupo03.desafio_testing.model.Room;
import com.grupo03.desafio_testing.services.IProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private IProperty propertyService;
    
    @PostMapping
    public ResponseEntity<Property> createProperty(@Valid @RequestBody Property property) {
        return new ResponseEntity<>(propertyService.createProperty(property), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Property>> getAll() {
        return new ResponseEntity<>(propertyService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<Room> getBiggestRoom(@PathVariable String id) {
        return new ResponseEntity<>(propertyService.getBiggestRoom(id), HttpStatus.OK);
    }
    
}
