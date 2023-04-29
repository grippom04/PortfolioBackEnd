/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   
   private String img;
   private String nombre_trabajo;
   private String nombre_compania;
   private String fecha_inicio;
   private String fecha_fin;
   private String descripcion;

    public Experiencia(String img, String nombre_trabajo, String nombre_compania, String fecha_inicio, String fecha_fin, String descripcion) {
        this.img = img;
        this.nombre_trabajo = nombre_trabajo;
        this.nombre_compania = nombre_compania;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.descripcion = descripcion;
    }

    public Experiencia() {
    }
    
    
   
   
      
}
