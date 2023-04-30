/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.controller;

import com.PruebaPortfolio.Prueba.model.Persona;
import com.PruebaPortfolio.Prueba.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfoliofrontend-3f1ea.web.app")
public class PersonaController {
    
    @Autowired
    private IPersonaService persoService;

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona/set")
    public void setPersona(@RequestBody Persona p){
       persoService.setPersona(p);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/delete/{id}")
    public void wipePersona(@PathVariable Long id){
           persoService.wipePersona(id);
    }
    
    @GetMapping("/persona/get/{id}")
    @ResponseBody
    public Persona getPersona(@PathVariable Long id){
        return persoService.getPersona(id);
    }
    
    @GetMapping("/persona/getAll")
    @ResponseBody
    public List<Persona> getAll(){
        return persoService.getAllPersona();
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persona/edit")
    public void editPersona(@RequestBody Persona p){
        persoService.editPersona(p);
    }
       
   
}
