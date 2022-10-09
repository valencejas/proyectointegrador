/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cejasportafolio.mgb.seguridad.controller;

import com.cejasportafolio.mgb.seguridad.Dto.JwtDTO;
import com.cejasportafolio.mgb.seguridad.Dto.LoginUsuario;
import com.cejasportafolio.mgb.seguridad.Dto.NuevoUsuario;
import com.cejasportafolio.mgb.seguridad.entidad.rol;
import com.cejasportafolio.mgb.seguridad.entidad.usuario;
import com.cejasportafolio.mgb.seguridad.enumeracion.rolNombre;
import com.cejasportafolio.mgb.seguridad.jwt.JwtProvider;
import com.cejasportafolio.mgb.seguridad.servicio.RolServicio;
import com.cejasportafolio.mgb.seguridad.servicio.UsuarioServicio;
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
@CrossOrigin
public class AuthController {
    @Autowired 
    PasswordEncoder passwordEncoder;
     @Autowired    
     AuthenticationManager authenticationManager;
     @Autowired 
     UsuarioServicio usuarioServicio;
     @Autowired 
     RolServicio rolServicio;
     @Autowired 
     JwtProvider jwtProvider;
     
     @PostMapping("/nuevo")
     public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
         if(bindingResult.hasErrors())
             return new ResponseEntity(new Mensaje("Campos mal puestos o email inavlido"), HttpStatus.BAD_REQUEST );
         
         if(usuarioServicio.existsBynombreUsuario(nuevoUsuario.getNombreUsuario()))
             return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
         
          if(usuarioServicio.existsByemail(nuevoUsuario.getEmail()))
             return new ResponseEntity(new Mensaje("Ese email de usuario ya existe"), HttpStatus.BAD_REQUEST);
          
          usuario usuario = new usuario(nuevoUsuario.getNombre(),nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),passwordEncoder.encode(nuevoUsuario.getContraseña()));
          
          Set<rol> roles = new HashSet<>();
          roles.add(rolServicio.getByrolNombre(rolNombre.ROL_USER).get());
          
          if(nuevoUsuario.getRoles().contains("admin"))
              roles.add(rolServicio.getByrolNombre(rolNombre.ROLE_ADMIN).get());
          usuario.setRoles(roles);
          usuarioServicio.save(usuario);
          
          return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
     }
     @PostMapping("/login")
public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult ){
         if(bindingResult.hasErrors())
             return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
         Authentication authetication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
         loginUsuario.getNombreUsuario(), loginUsuario.getContraseña()));
         
         SecurityContextHolder.getContext().setAuthentication(authetication);
         
         String jwt = jwtProvider.generateToken(authetication);
         
         UserDetails userDetails = (UserDetails) authetication.getPrincipal();
         
         JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
         
         return new ResponseEntity(jwtDto, HttpStatus.OK);
     }
}
