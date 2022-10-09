
package com.cejasportafolio.mgb.seguridad.servicio;

import com.cejasportafolio.mgb.seguridad.entidad.rol;
import com.cejasportafolio.mgb.seguridad.enumeracion.rolNombre;
import com.cejasportafolio.mgb.seguridad.repositorio.IRolRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolServicio {
    @Autowired
    IRolRepositorio IRolRepositorio;
    public Optional<rol> getByrolNombre(rolNombre rolNombre){
        return IRolRepositorio.findrolNombre(rolNombre);
    }
    public void save(rol rol){
        IRolRepositorio.save(rol);
    }
}
