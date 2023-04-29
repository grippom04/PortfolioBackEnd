/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.service;

import com.PruebaPortfolio.Prueba.model.Experiencia;
import com.PruebaPortfolio.Prueba.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService implements IExperienciaService {
    
    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Override
    public Experiencia getExperiencia(Long id) {
        return experienciaRepository.findById(id).orElse(null);
    }

    @Override
    public void setExperiencia(Experiencia e) {
        experienciaRepository.save(e);
    }

    @Override
    public void wipeExperiencia(Long id) {
        experienciaRepository.deleteById(id);
    }

    @Override
    public List<Experiencia> getAllExperiencia() {
        return experienciaRepository.findAll();
    }

    @Override
    public void editExperiencia(Experiencia e) {
        experienciaRepository.save(e);       
    }
    
    public boolean existById(Long id){
        boolean retorno = false;
        if(experienciaRepository.findById(id).orElse(null)!= null)
            retorno=true;
        return retorno;
    }
    
    
 
           
}
