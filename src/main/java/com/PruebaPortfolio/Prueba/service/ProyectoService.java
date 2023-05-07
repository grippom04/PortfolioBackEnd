/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.service;

import com.PruebaPortfolio.Prueba.model.Proyecto;
import com.PruebaPortfolio.Prueba.repository.ProyectoRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService implements IProyectoService{
    
    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public Proyecto getProyecto(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    public void setProyecto(Proyecto p) {
        proyectoRepository.save(p);
    }

    @Override
    public void wipeProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public void editProyecto(Proyecto p) {
        proyectoRepository.save(p);
    }

    @Override
    public boolean existById(Long id) {
        boolean retorno = false;
        if(proyectoRepository.findById(id).orElse(null)!= null)
            retorno=true;
        return retorno; 
    }

    @Override
    public List<Proyecto> getAllProyecto() {
        return proyectoRepository.findAll();
    }
    
}
