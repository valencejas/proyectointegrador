
package com.cejasportafolio.mgb.seguridad.repositorio;

import com.cejasportafolio.mgb.seguridad.entidad.rol;
import com.cejasportafolio.mgb.seguridad.enumeracion.rolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepositorio extends JpaRepository<rol, Integer>{
    Optional<rol> findrolNombre(rolNombre rolNombre);
}
