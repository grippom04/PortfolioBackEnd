/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PruebaPortfolio.Prueba.service;

import com.PruebaPortfolio.Prueba.model.Experiencia;
import java.util.List;
import java.util.Optional;


public interface IExperienciaService {
    
    public Experiencia getExperiencia(Long id);
    public void setExperiencia(Experiencia e);
    public void wipeExperiencia(Long id);
    public List<Experiencia> getAllExperiencia();
    public void editExperiencia(Experiencia p);
    public boolean existById(Long id);
}
