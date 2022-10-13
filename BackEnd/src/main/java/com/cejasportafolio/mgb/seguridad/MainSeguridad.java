/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cejasportafolio.mgb.seguridad;

import com.cejasportafolio.mgb.seguridad.jwt.JwtEntryPoint;

import com.cejasportafolio.mgb.seguridad.servicio.Implementacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSeguridad extends WebSecurityConfigurerAdapter {
    @Autowired 
   Implementacion implementacion ;
     @Autowired 
     JwtEntryPoint jwtEntryPoint;
      
     
}
