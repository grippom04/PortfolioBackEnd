/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.controller;

import com.PruebaPortfolio.Prueba.DTO.DtoProyecto;
import com.PruebaPortfolio.Prueba.model.Proyecto;
import com.PruebaPortfolio.Prueba.security.controller.Mensaje;
import com.PruebaPortfolio.Prueba.service.IProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = {"https://portfoliofrontend-mg-d9084.web.app","http://localhost:4200"})
//@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    
    @Autowired
    IProyectoService iProyectoService;
    
    @PostMapping("/set")
    public ResponseEntity<?> setProyecto(@RequestBody DtoProyecto dtoProyecto){
        if(StringUtils.isBlank(dtoProyecto.getNombre_proyecto()) ||
           StringUtils.isBlank(dtoProyecto.getDescripcion()) ||
           StringUtils.isBlank(dtoProyecto.getFecha_inicio().toString()))
        return new ResponseEntity(new Mensaje("Campos Obligatorios faltantes"),HttpStatus.BAD_REQUEST);
        
        else{
            Proyecto proyecto = new Proyecto(dtoProyecto.getImg(),
                                                  dtoProyecto.getNombre_proyecto(),
                                                  dtoProyecto.getFecha_inicio(),
                                                  dtoProyecto.getDescripcion(),
                                                  dtoProyecto.getLink());
            iProyectoService.setProyecto(proyecto);
            return new ResponseEntity(new Mensaje("Proyecto creado!"),HttpStatus.OK);
        }
              
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> wipeProyecto(@PathVariable Long id){
        if(iProyectoService.existById(id)){
            iProyectoService.wipeProyecto(id);
            return new ResponseEntity(new Mensaje("Proyecto borrado!"),HttpStatus.OK);
        }
        else{
            return new ResponseEntity(new Mensaje("El id solicitado no existe!"),HttpStatus.BAD_REQUEST);
        }          
    }
    
    @GetMapping("/get/{id}")
    @ResponseBody
    public Proyecto getProyecto(@PathVariable Long id){
        return iProyectoService.getProyecto(id);
    }
    
    @GetMapping("/getAll")    
    public ResponseEntity<List<Proyecto>> getAllProyecto(){
        List<Proyecto> list = iProyectoService.getAllProyecto();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit")
    public ResponseEntity<?> editEducacion(@RequestBody  DtoProyecto dtoProyecto){
        
        if( StringUtils.isBlank(dtoProyecto.getNombre_proyecto()) ||
           StringUtils.isBlank(dtoProyecto.getDescripcion()) ||
           StringUtils.isBlank(dtoProyecto.getFecha_inicio().toString()))            
            return new ResponseEntity(new Mensaje("Campos Obligatorios faltantes"),HttpStatus.BAD_REQUEST);

        else{
            Proyecto proyecto = new Proyecto(dtoProyecto.getImg(),
                                                  dtoProyecto.getNombre_proyecto(),
                                                  dtoProyecto.getFecha_inicio(),
                                                  dtoProyecto.getDescripcion(),
                                                  dtoProyecto.getLink());
            proyecto.setId(dtoProyecto.getId());
            iProyectoService.setProyecto(proyecto);
            return new ResponseEntity(new Mensaje("Proyecto modificada!"),HttpStatus.OK);
        }       
    }
    
    
    
}
