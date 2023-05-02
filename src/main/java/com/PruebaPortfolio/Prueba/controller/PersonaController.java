/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.controller;

import com.PruebaPortfolio.Prueba.DTO.DtoPersona;
import com.PruebaPortfolio.Prueba.model.Persona;
import com.PruebaPortfolio.Prueba.security.controller.Mensaje;
import com.PruebaPortfolio.Prueba.service.IPersonaService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "https://portfoliofrontend-mg-d9084.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    //@PreAuthorize("hasRole('ADMIN')")
    @Autowired
    private IPersonaService iPersonaService;

    @PostMapping("/set")
    public ResponseEntity<?> setPersona(@RequestBody DtoPersona dtoPersona){
        if(StringUtils.isBlank(dtoPersona.getNombre()) ||
           StringUtils.isBlank(dtoPersona.getApellido()) ||
           StringUtils.isBlank(dtoPersona.getNacimiento()))
        return new ResponseEntity(new Mensaje("Campos Obligatorios faltantes"),HttpStatus.BAD_REQUEST);
        
        else{
            Persona persona = new Persona(dtoPersona.getNombre(),
                                        dtoPersona.getApellido(),
                                      dtoPersona.getNacimiento(),
                                      dtoPersona.getDescripcion(),
                                            dtoPersona.getImg());
        iPersonaService.setPersona(persona);
        return new ResponseEntity(new Mensaje("Persona creada!"),HttpStatus.OK);
        }              
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> wipePersona(@PathVariable Long id){
        if(iPersonaService.existById(id)){
            iPersonaService.wipePersona(id);
            return new ResponseEntity(new Mensaje("Persona borrada!"),HttpStatus.OK);
        }
        else{
            return new ResponseEntity(new Mensaje("El id solicitado no existe!"),HttpStatus.BAD_REQUEST);
        }
          
    }
    
    @GetMapping("/get/{id}")
    @ResponseBody
    public Persona getPersona(@PathVariable Long id){
        return iPersonaService.getPersona(id);
    }
    
    @GetMapping("/getAll")    
    public ResponseEntity<List<Persona>> getAllPersona(){
        List<Persona> list = iPersonaService.getAllPersona();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit")
    public ResponseEntity<?> editPersona(@RequestBody  DtoPersona dtoPersona){
        
        if(StringUtils.isBlank(dtoPersona.getNombre()) ||
           StringUtils.isBlank(dtoPersona.getApellido()) ||
           StringUtils.isBlank(dtoPersona.getNacimiento()))
        return new ResponseEntity(new Mensaje("Campos Obligatorios faltantes"),HttpStatus.BAD_REQUEST);
        
        else{
            Persona persona = new Persona(dtoPersona.getNombre(),
                                        dtoPersona.getApellido(),
                                      dtoPersona.getNacimiento(),
                                      dtoPersona.getDescripcion(),
                                            dtoPersona.getImg());
        persona.setId(dtoPersona.getId());
        iPersonaService.setPersona(persona);
        return new ResponseEntity(new Mensaje("Persona editada!"),HttpStatus.OK);
        }     
    }

}
