/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.controller;

import com.PruebaPortfolio.Prueba.DTO.DtoEducacion;
import com.PruebaPortfolio.Prueba.model.Educacion;
import com.PruebaPortfolio.Prueba.security.controller.Mensaje;
import com.PruebaPortfolio.Prueba.service.IEducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    
    @Autowired
    IEducacionService iEducacionService;
    
    @PostMapping("/educacion/set")
    public ResponseEntity<?> setEducacion(@RequestBody DtoEducacion dtoEducacion){
        if(StringUtils.isBlank(dtoEducacion.getNombre_colegio()) ||
           StringUtils.isBlank(dtoEducacion.getNombre_titulo()) ||
           StringUtils.isBlank(dtoEducacion.getFecha_fin().toString()) ||
           StringUtils.isBlank(dtoEducacion.getFecha_inicio().toString()))
        return new ResponseEntity(new Mensaje("Campos Obligatorios faltantes"),HttpStatus.BAD_REQUEST);
        
        else{
            Educacion educacion = new Educacion(dtoEducacion.getImg(),
                                                  dtoEducacion.getNombre_titulo(),
                                                  dtoEducacion.getNombre_colegio(),
                                                  dtoEducacion.getFecha_inicio(),
                                                  dtoEducacion.getFecha_fin(),
                                                  dtoEducacion.getDescripcion());
            iEducacionService.setEducacion(educacion);
            return new ResponseEntity(new Mensaje("Educacion creada!"),HttpStatus.OK);
        }
              
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/educacion/delete/{id}")
    public ResponseEntity<?> wipeEducacion(@PathVariable Long id){
        if(iEducacionService.existById(id)){
            iEducacionService.wipeEducacion(id);
            return new ResponseEntity(new Mensaje("Educacion borrada!"),HttpStatus.OK);
        }
        else{
            return new ResponseEntity(new Mensaje("El id solicitado no existe!"),HttpStatus.BAD_REQUEST);
        }          
    }
    
    @GetMapping("/educacion/get/{id}")
    @ResponseBody
    public Educacion getEducacion(@PathVariable Long id){
        return iEducacionService.getEducacion(id);
    }
    
    @GetMapping("/educacion/getAll")    
    public ResponseEntity<List<Educacion>> getAllEducacion(){
        List<Educacion> list = iEducacionService.getAllEducacion();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/educacion/edit")
    public ResponseEntity<?> editEducacion(@RequestBody  DtoEducacion dtoEducacion){
        
        if( StringUtils.isBlank(dtoEducacion.getNombre_titulo()) ||
            StringUtils.isBlank(dtoEducacion.getNombre_colegio()) ||
            StringUtils.isBlank(dtoEducacion.getFecha_fin().toString()) ||
            StringUtils.isBlank(dtoEducacion.getFecha_inicio().toString())){            
            return new ResponseEntity(new Mensaje("Campos Obligatorios faltantes"),HttpStatus.BAD_REQUEST);
        }
        else{
            Educacion educacion = new Educacion(dtoEducacion.getImg(),
                                                  dtoEducacion.getNombre_titulo(),
                                                  dtoEducacion.getNombre_colegio(),
                                                  dtoEducacion.getFecha_inicio(),
                                                  dtoEducacion.getFecha_fin(),
                                                  dtoEducacion.getDescripcion());
            educacion.setId(dtoEducacion.getId());
            iEducacionService.setEducacion(educacion);
            return new ResponseEntity(new Mensaje("Educacion modificada!"),HttpStatus.OK);
        }       
    }
    
}
