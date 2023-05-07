/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   
   private String img;
   private String nombre_proyecto;
   private String fecha_inicio;
   private String descripcion;  
   private String link; 

    public Proyecto(String img, String nombre_proyecto, String fecha_inicio, String descripcion, String link) {
        this.img = img;
        this.nombre_proyecto = nombre_proyecto;
        this.fecha_inicio = fecha_inicio;
        this.descripcion = descripcion;
        this.link = link;
    }

    public Proyecto() {
    }
   
    
    
}
