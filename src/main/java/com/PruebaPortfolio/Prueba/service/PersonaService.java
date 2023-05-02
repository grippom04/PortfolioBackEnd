/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.service;

import com.PruebaPortfolio.Prueba.model.Persona;
import com.PruebaPortfolio.Prueba.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private PersonaRepository persoRepo;

    @Override
    public Persona getPersona(Long id) {
       return persoRepo.findById(id).orElse(null);
    }

    @Override
    public void setPersona(Persona p) {
        persoRepo.save(p);
    }

    @Override
    public void wipePersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public List<Persona> getAllPersona() {
       return persoRepo.findAll();
    }
    
    @Override
    public void editPersona(Persona p) {
       persoRepo.save(p);
    }
    
     @Override
     public boolean existById(Long id){
        boolean retorno = false;
        if(persoRepo.findById(id).orElse(null)!= null)
            retorno=true;
        return retorno;
    }
    
}
