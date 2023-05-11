/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.controller;

import com.PruebaPortfolio.Prueba.DTO.DtoExperiencia;
import com.PruebaPortfolio.Prueba.model.Experiencia;
import com.PruebaPortfolio.Prueba.security.controller.Mensaje;
import com.PruebaPortfolio.Prueba.service.IExperienciaService;
import com.PruebaPortfolio.Prueba.service.IPersonaService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = {"https://portfoliofrontend-mg-d9084.web.app","http://localhost:4200"})
public class ExperienciaController {
    
    @Autowired
    IExperienciaService iExperienciaService;
    
    @PostMapping("/set")
    public ResponseEntity<?> setExperiencia(@RequestBody DtoExperiencia dtoExperiencia){
        if(StringUtils.isBlank(dtoExperiencia.getNombre_compania()) ||
           StringUtils.isBlank(dtoExperiencia.getNombre_trabajo()) ||
           StringUtils.isBlank(dtoExperiencia.getFecha_fin().toString()) ||
           StringUtils.isBlank(dtoExperiencia.getFecha_inicio().toString()))
        return new ResponseEntity(new Mensaje("Campos Obligatorios faltantes"),HttpStatus.BAD_REQUEST);
        
        else{
            Experiencia experiencia = new Experiencia(dtoExperiencia.getImg(),
                                                  dtoExperiencia.getNombre_trabajo(),
                                                  dtoExperiencia.getNombre_compania(),
                                                  dtoExperiencia.getFecha_inicio(),
                                                  dtoExperiencia.getFecha_fin(),
                                                  dtoExperiencia.getDescripcion());
        iExperienciaService.setExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia creada!"),HttpStatus.OK);
        }
              
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> wipeExperiencia(@PathVariable Long id){
        if(iExperienciaService.existById(id)){
            iExperienciaService.wipeExperiencia(id);
            return new ResponseEntity(new Mensaje("Experiencia borrada!"),HttpStatus.OK);
        }
        else{
            return new ResponseEntity(new Mensaje("El id solicitado no existe!"),HttpStatus.BAD_REQUEST);
        }
          
    }
    
    @GetMapping("/get/{id}")
    @ResponseBody
    public Experiencia getExperiencia(@PathVariable Long id){
        return iExperienciaService.getExperiencia(id);
    }
    
    @GetMapping("/getAll")    
    public ResponseEntity<List<Experiencia>> getAllExperiencia(){
        List<Experiencia> list = iExperienciaService.getAllExperiencia();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit")
    public ResponseEntity<?> editExperiencia(@RequestBody  DtoExperiencia dtoExperiencia){
        
        if( StringUtils.isBlank(dtoExperiencia.getNombre_trabajo()) ||
            StringUtils.isBlank(dtoExperiencia.getNombre_compania()) ||
            StringUtils.isBlank(dtoExperiencia.getFecha_fin().toString()) ||
            StringUtils.isBlank(dtoExperiencia.getFecha_inicio().toString())){            
            return new ResponseEntity(new Mensaje("Campos Obligatorios faltantes"),HttpStatus.BAD_REQUEST);
        }
        else{
            Experiencia experiencia = new Experiencia(dtoExperiencia.getImg(),
                                                  dtoExperiencia.getNombre_trabajo(),
                                                  dtoExperiencia.getNombre_compania(),
                                                  dtoExperiencia.getFecha_inicio(),
                                                  dtoExperiencia.getFecha_fin(),
                                                  dtoExperiencia.getDescripcion());
            experiencia.setId(dtoExperiencia.getId());
            iExperienciaService.setExperiencia(experiencia);
            return new ResponseEntity(new Mensaje("Experiencia creada!"),HttpStatus.OK);
        }
          
    }
}
