/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ista.ProyectoMongo.service;

import com.ista.ProyectoMongo.model.Persona;
import com.ista.ProyectoMongo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Genesis
 */
@Service
public class PersonaServiceImpl extends GenericServiceImpl <Persona, Long> implements PersonaService{

    @Autowired
    PersonaRepository personarepository;
    
    
    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personarepository;
    }
    
    
}
