/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.DTO;

import javax.validation.constraints.NotBlank;

public class DtoSkill {
    
   private Long id;
   

   private String img;
   @NotBlank
   private int porcentaje;
   private String outerColor;
   private String innerColor;
   private String nombre;

    public DtoSkill(String img, int porcentaje, String outerColor, String innerColor,String nombre) {
        this.img = img;
        this.porcentaje = porcentaje;
        this.outerColor = outerColor;
        this.innerColor = innerColor;
        this.nombre=nombre;
        
    }

    public DtoSkill() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getOuterColor() {
        return outerColor;
    }

    public void setOuterColor(String outerColor) {
        this.outerColor = outerColor;
    }

    public String getInnerColor() {
        return innerColor;
    }

    public void setInnerColor(String innerColor) {
        this.innerColor = innerColor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
   
    
}
