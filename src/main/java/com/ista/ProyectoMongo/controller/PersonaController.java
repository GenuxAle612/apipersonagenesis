/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ista.ProyectoMongo.controller;

import com.ista.ProyectoMongo.model.Persona;
import com.ista.ProyectoMongo.service.PersonaServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Genesis
 */
@RestController
@RequestMapping("/api/persona")
public class PersonaController {
      
    @Autowired
    PersonaServiceImpl personaServiceImpl;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listar() {
        return new ResponseEntity<>(personaServiceImpl.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona p) {
        return new ResponseEntity<>(personaServiceImpl.save(p), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Persona> eliminarPerona(@PathVariable Long id) {
        personaServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona p) {
        Persona persona = personaServiceImpl.findById(id);
        if (persona == null) {
            System.out.println("aqui no");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);           
        } else {
            try {
                persona.setNombre(p.getNombre());
                persona.setApellido(p.getApellido());
                persona.setCedula(p.getCedula());
                persona.setCorreo(p.getCorreo());
                System.out.println("aqui tampoco");
                return new ResponseEntity<>(personaServiceImpl.save(persona), HttpStatus.OK);
            } catch (Exception ex) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
}
