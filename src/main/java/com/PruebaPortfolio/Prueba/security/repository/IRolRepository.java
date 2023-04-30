/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PruebaPortfolio.Prueba.security.repository;

import com.PruebaPortfolio.Prueba.security.entity.Rol;
import com.PruebaPortfolio.Prueba.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol>findByRolNombre(RolNombre rolNombre);
}
