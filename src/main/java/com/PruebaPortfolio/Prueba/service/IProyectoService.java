/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PruebaPortfolio.Prueba.service;

import com.PruebaPortfolio.Prueba.model.Proyecto;
import java.util.List;

/**
 *
 * @author migue
 */
public interface IProyectoService {
    
    public Proyecto getProyecto(Long id);
    public void setProyecto(Proyecto e);
    public void wipeProyecto(Long id);
    public List<Proyecto> getAllProyecto();
    public void editProyecto(Proyecto p);
    public boolean existById(Long id);
}
