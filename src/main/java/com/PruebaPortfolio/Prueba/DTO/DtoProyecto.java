/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author migue
 */
public class DtoProyecto {

   private Long id;  
   private String img;
   @NotBlank
   private String nombre_proyecto;
   private String fecha_inicio;
   @NotBlank
   private String descripcion; 
   @NotBlank
   private String link;

    public DtoProyecto(String img, String nombre_proyecto, String fecha_inicio, String descripcion, String link) {
        this.img = img;
        this.nombre_proyecto = nombre_proyecto;
        this.fecha_inicio = fecha_inicio;
        this.descripcion = descripcion;
        this.link = link;
    }

    public DtoProyecto() {
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

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
   
   
}
