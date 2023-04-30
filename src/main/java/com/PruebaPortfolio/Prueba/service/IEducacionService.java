/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PruebaPortfolio.Prueba.service;

import com.PruebaPortfolio.Prueba.model.Educacion;
import com.PruebaPortfolio.Prueba.model.Experiencia;
import java.util.List;

/**
 *
 * @author migue
 */
public interface IEducacionService {
    
    public Educacion getEducacion(Long id);
    public void setEducacion(Educacion e);
    public void wipeEducacion(Long id);
    public List<Educacion> getAllEducacion();
    public void editEducacion(Educacion e);
    public boolean existById(Long id);
    
}
