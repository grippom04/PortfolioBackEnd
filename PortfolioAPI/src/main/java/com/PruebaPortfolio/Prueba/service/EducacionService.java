/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.service;

import com.PruebaPortfolio.Prueba.model.Educacion;
import com.PruebaPortfolio.Prueba.model.Experiencia;
import com.PruebaPortfolio.Prueba.repository.EducacionRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService implements IEducacionService{

    @Autowired
    private EducacionRepository educacionRepository;

    @Override
    public Educacion getEducacion(Long id) {
        return educacionRepository.findById(id).orElse(null);
    }

    @Override
    public void setEducacion(Educacion e) {
        educacionRepository.save(e);
    }

    @Override
    public void wipeEducacion(Long id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public List<Educacion> getAllEducacion() {
       return educacionRepository.findAll();
    }

    @Override
    public void editEducacion(Educacion e) {
        educacionRepository.save(e);
    }

    @Override
    public boolean existById(Long id) {
        boolean retorno = false;
        if(educacionRepository.findById(id).orElse(null)!= null)
            retorno=true;
        return retorno; 
    }
    
  
    
}
