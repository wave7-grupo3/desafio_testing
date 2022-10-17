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

    /**
     * Rota responsável pela criação de uma propriedade.
     * @author Grupo 03
     * @param property - Property
     * @return Property - Retorna uma entidade do tipo Property.
     */
    @PostMapping
    public ResponseEntity<Property> createProperty(@Valid @RequestBody Property property) {
        return new ResponseEntity<>(propertyService.createProperty(property), HttpStatus.CREATED);
    }

    /**
     * Rota responsável por listar todas as propriedades.
     * @author Grupo 03
     * @return List<Property> - Retorna uma lista de Propriedades.
     */
    @GetMapping()
    public ResponseEntity<List<Property>> getAll() {
        return new ResponseEntity<>(propertyService.getAll(), HttpStatus.OK);
    }

    /**
     * Rota responsável por retornar o maior comodo de uma propriedade.
     * @author Grupo 03
     * @param id - String
     * @return Room - Retorna uma entidade do tipo Room.
     */
    @GetMapping("/room/{id}")
    public ResponseEntity<Room> getBiggestRoom(@PathVariable String id) {
        return new ResponseEntity<>(propertyService.getBiggestRoom(id), HttpStatus.OK);
    }
    
}
