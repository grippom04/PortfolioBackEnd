/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.controller;

import com.PruebaPortfolio.Prueba.DTO.DtoSkill;
import com.PruebaPortfolio.Prueba.model.Skill;
import com.PruebaPortfolio.Prueba.security.controller.Mensaje;
import com.PruebaPortfolio.Prueba.service.ISkillService;
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
@RequestMapping("/skill")
@CrossOrigin(origins = {"https://portfoliofrontend-mg-d9084.web.app","http://localhost:4200"})
public class SkillController {
    
    @Autowired
    ISkillService iSkillService;
    
    @PostMapping("/set")
    public ResponseEntity<?> setSkill(@RequestBody DtoSkill dtoSkill){
        if(dtoSkill.getPorcentaje()<=0 || StringUtils.isBlank(dtoSkill.getNombre()))
        return new ResponseEntity(new Mensaje("Campos Obligatorios faltantes"),HttpStatus.BAD_REQUEST);
        
        else{
            Skill skill = new Skill(dtoSkill.getImg(),
                            dtoSkill.getPorcentaje(),
                            dtoSkill.getOuterColor(),
                            dtoSkill.getInnerColor(),
                            dtoSkill.getNombre());

        iSkillService.setSkill(skill);
        return new ResponseEntity(new Mensaje("Skill creado!"),HttpStatus.OK);
        }
              
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> wipeSkill(@PathVariable Long id){
        if(iSkillService.existById(id)){
            iSkillService.wipeSkill(id);
            return new ResponseEntity(new Mensaje("Skill borrada!"),HttpStatus.OK);
        }
        else{
            return new ResponseEntity(new Mensaje("El id solicitado no existe!"),HttpStatus.BAD_REQUEST);
        }
          
    }
    
    @GetMapping("/get/{id}")
    @ResponseBody
    public Skill getSkill(@PathVariable Long id){
        return iSkillService.getSkill(id);
    }
    
    @GetMapping("/getAll")    
    public ResponseEntity<List<Skill>> getAllSkill(){
        List<Skill> list = iSkillService.getAllSkill();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit")
    public ResponseEntity<?> editSkill(@RequestBody  DtoSkill dtoSkill){
        
        if(dtoSkill.getPorcentaje()<=0)
        return new ResponseEntity(new Mensaje("Campos Obligatorios faltantes"),HttpStatus.BAD_REQUEST);
        
        else{
            Skill skill = new Skill(dtoSkill.getImg(),
                              dtoSkill.getPorcentaje(),
                              dtoSkill.getOuterColor(),
                              dtoSkill.getInnerColor(),
                              dtoSkill.getNombre());
            
            skill.setId(dtoSkill.getId());
            iSkillService.setSkill(skill);
            return new ResponseEntity(new Mensaje("Skill Modificada!"),HttpStatus.OK);
        }
          
    }
    
                     

}
