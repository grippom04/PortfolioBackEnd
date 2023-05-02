/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.DTO;

import java.util.Date;
import javax.validation.constraints.NotBlank;



public class DtoPersona {
    
   private Long id;
   
   @NotBlank
   private String nombre;
   @NotBlank
   private String apellido;
   private String nacimiento;
   private String descripcion;
   private String img;

    public DtoPersona(String nombre, String apellido, String nacimiento, String descripcion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.descripcion = descripcion;
        this.img = img;
    }

    public DtoPersona() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
   
   
}
