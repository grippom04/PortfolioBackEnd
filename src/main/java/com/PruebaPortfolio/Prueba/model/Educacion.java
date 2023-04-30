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
public class Educacion {
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   
   private String img;
   private String nombre_titulo;
   private String nombre_colegio;
   private String fecha_inicio;
   private String fecha_fin;
   private String descripcion;

    public Educacion(String img, String nombre_titulo, String nombre_colegio, String fecha_inicio, String fecha_fin, String descripcion) {
        this.img = img;
        this.nombre_titulo = nombre_titulo;
        this.nombre_colegio = nombre_colegio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.descripcion = descripcion;
    }

    public Educacion() {
    }
   
   
}

