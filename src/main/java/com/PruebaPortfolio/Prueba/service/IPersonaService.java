/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PruebaPortfolio.Prueba.service;

import com.PruebaPortfolio.Prueba.model.Persona;
import java.util.List;

/**
 *
 * @author migue
 */
public interface IPersonaService {
    
    public Persona getPersona(Long id);
    public void setPersona(Persona p);
    public void wipePersona(Long id);
    public List<Persona> getAllPersona();
    public void editPersona(Persona p);

}
