/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cejasportafolio.mgb.seguridad.Dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;



public class JwtDTO {
    private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authoritieses;
    
    //contructor

    public JwtDTO(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authoritieses) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.authoritieses = authoritieses;
    }
    //g y s

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Collection<? extends GrantedAuthority> getAuthoritieses() {
        return authoritieses;
    }

    public void setAuthoritieses(Collection<? extends GrantedAuthority> authoritieses) {
        this.authoritieses = authoritieses;
    }
    
}
