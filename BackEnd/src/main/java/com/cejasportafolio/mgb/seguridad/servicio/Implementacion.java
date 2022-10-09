package com.cejasportafolio.mgb.seguridad.servicio;

import com.cejasportafolio.mgb.seguridad.entidad.usuario;
import com.cejasportafolio.mgb.seguridad.entidad.usuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Implementacion implements UserDetailsService{
    @Autowired
   UsuarioServicio usuarioServicio; 

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        usuario usuario= usuarioServicio.getBynombreUsuario(nombreUsuario).get();
        return usuarioPrincipal.build(usuario);
    }
}
