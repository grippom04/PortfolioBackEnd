/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.DTO;

import javax.validation.constraints.NotBlank;


public class DtoEducacion {
    
    private Long id;
   
   private String img;
   @NotBlank
   private String nombre_titulo;
   @NotBlank
   private String nombre_colegio;
   private String fecha_inicio;
   private String fecha_fin;
   private String descripcion;

    public DtoEducacion(String nombre_titulo, String nombre_colegio, String fecha_inicio, String fecha_fin) {
        this.nombre_titulo = nombre_titulo;
        this.nombre_colegio = nombre_colegio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public DtoEducacion() {
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

    public String getNombre_titulo() {
        return nombre_titulo;
    }

    public void setNombre_titulo(String nombre_titulo) {
        this.nombre_titulo = nombre_titulo;
    }

    public String getNombre_colegio() {
        return nombre_colegio;
    }

    public void setNombre_colegio(String nombre_colegio) {
        this.nombre_colegio = nombre_colegio;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
   
}
