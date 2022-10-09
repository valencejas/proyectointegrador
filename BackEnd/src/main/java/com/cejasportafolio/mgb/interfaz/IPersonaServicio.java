
package com.cejasportafolio.mgb.interfaz;

import com.cejasportafolio.mgb.entidad.persona;
import java.util.List;

public interface IPersonaServicio {
    public List<persona> getpersona();
    
    //guardar objeto tipo persona
    public void savePersona(persona persona);
    //eliminar objeto por busqueda id
    public void deletePersona(Long id);
    //buscar persona por id
    public persona findPersona(Long id);
}
