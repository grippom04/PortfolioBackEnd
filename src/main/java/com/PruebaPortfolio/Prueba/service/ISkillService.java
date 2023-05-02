/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PruebaPortfolio.Prueba.service;

import com.PruebaPortfolio.Prueba.model.Skill;
import java.util.List;

/**
 *
 * @author migue
 */
public interface ISkillService {
    
    public Skill getSkill(Long id);
    public void setSkill(Skill e);
    public void wipeSkill(Long id);
    public List<Skill> getAllSkill();
    public void editSkill(Skill s);
    public boolean existById(Long id);
}
