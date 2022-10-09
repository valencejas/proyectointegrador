
package com.cejasportafolio.mgb.repositorio;

import com.cejasportafolio.mgb.entidad.persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepositorio extends JpaRepository<persona, Long>{
    
}
