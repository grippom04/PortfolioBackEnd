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
public class Skill {
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   
   private String img;
   private int porcentaje;
   private String outerColor;
   private String innerColor;
   private String nombre;

    public Skill(String img, int porcentaje, String outerColor, String innerColor,String nombre) {
        this.img = img;
        this.porcentaje = porcentaje;
        this.outerColor = outerColor;
        this.innerColor = innerColor;
        this.nombre=nombre;
    }

    public Skill() {
    }
   
   
}
