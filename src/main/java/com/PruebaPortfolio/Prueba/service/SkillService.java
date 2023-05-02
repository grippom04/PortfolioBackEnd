/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.service;

import com.PruebaPortfolio.Prueba.model.Skill;
import com.PruebaPortfolio.Prueba.repository.SkillRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillService implements ISkillService{
    
    @Autowired
    private SkillRepository skillRepository;

    @Override
    public Skill getSkill(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public void setSkill(Skill s) {
        skillRepository.save(s);
    }

    @Override
    public void wipeSkill(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public List<Skill> getAllSkill() {
       return skillRepository.findAll();
    }

    @Override
    public void editSkill(Skill s) {
        skillRepository.save(s);
    }

    @Override
    public boolean existById(Long id) {
        boolean retorno = false;
        if(skillRepository.findById(id).orElse(null)!= null)
            retorno=true;
        return retorno;
    }
    
    
    
}
