/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PruebaPortfolio.Prueba.security.controller;

import com.PruebaPortfolio.Prueba.security.dto.JwtDto;
import com.PruebaPortfolio.Prueba.security.dto.LoguinUsuario;
import com.PruebaPortfolio.Prueba.security.dto.NuevoUsuario;
import com.PruebaPortfolio.Prueba.security.entity.Rol;
import com.PruebaPortfolio.Prueba.security.entity.Usuario;
import com.PruebaPortfolio.Prueba.security.enums.RolNombre;
import com.PruebaPortfolio.Prueba.security.jwt.JwtProvider;
import com.PruebaPortfolio.Prueba.security.service.RolService;
import com.PruebaPortfolio.Prueba.security.service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"https://portfoliofrontend-mg-d9084.web.app","http://localhost:4200"})
//@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario,BindingResult bindingResult){
        
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos erroneos"),HttpStatus.BAD_REQUEST);
        
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
             return new ResponseEntity(new Mensaje("Nombre de usuario ocupado"),HttpStatus.BAD_REQUEST);
        
         if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
             return new ResponseEntity(new Mensaje("Email ocupado"),HttpStatus.BAD_REQUEST);
         
         Usuario usuario = new Usuario(nuevoUsuario.getNombre(),nuevoUsuario.getNombreUsuario(),
         nuevoUsuario.getEmail(),passwordEncoder.encode(nuevoUsuario.getPassword()));
         
         Set<Rol> roles = new HashSet<>();
         roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
         
         if(nuevoUsuario.getRoles().contains("admin"))
             roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
         
         usuario.setRoles(roles);
         usuarioService.save(usuario);
         
         return new ResponseEntity(new Mensaje("Usuario guardado"),HttpStatus.CREATED);
    }
    
    @PostMapping("/loguin")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoguinUsuario loguinUsuario,BindingResult bindingResult ){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos con errores"),HttpStatus.BAD_REQUEST);
        
        Authentication  authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loguinUsuario.getNombreUsuario(),loguinUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt,userDetails.getUsername(),userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto,HttpStatus.OK);
    }
}
