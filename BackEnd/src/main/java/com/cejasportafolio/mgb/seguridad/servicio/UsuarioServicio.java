
package com.cejasportafolio.mgb.seguridad.servicio;

import com.cejasportafolio.mgb.seguridad.entidad.usuario;
import com.cejasportafolio.mgb.seguridad.repositorio.IUsuarioRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioServicio {
    @Autowired
    IUsuarioRepositorio iUsuarioRepositorio;
    public Optional<usuario> getBynombreUsuario(String nombreUsuario){
        return iUsuarioRepositorio.findBynombreUsuario(nombreUsuario);
    }
    public boolean existsBynombreUsuario(String nombreUsuario){
        return iUsuarioRepositorio.existsBynombreUsuario(nombreUsuario);
    }
    public boolean existsByemail(String email){
        return iUsuarioRepositorio.existsByemail(email);
    }
    public void save(usuario usuario){
        iUsuarioRepositorio.save(usuario);
    }
}
