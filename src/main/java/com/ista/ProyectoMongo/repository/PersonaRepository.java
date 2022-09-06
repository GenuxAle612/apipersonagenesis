/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ista.ProyectoMongo.repository;

import com.ista.ProyectoMongo.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Genesis
 */
public interface PersonaRepository extends MongoRepository<Persona, Long>{
    
}
