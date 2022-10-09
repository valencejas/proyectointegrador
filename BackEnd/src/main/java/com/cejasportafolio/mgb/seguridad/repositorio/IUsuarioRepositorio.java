
package com.cejasportafolio.mgb.seguridad.repositorio;

import com.cejasportafolio.mgb.seguridad.entidad.usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<usuario, Integer> {
    Optional<usuario> findBynombreUsuario(String nombreUsuario);
    boolean existsBynombreUsuario(String nombreUsuariio);
    boolean existsByemail(String email);
}
