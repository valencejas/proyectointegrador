/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cejasportafolio.mgb.servicio;

import com.cejasportafolio.mgb.entidad.persona;
import com.cejasportafolio.mgb.interfaz.IPersonaServicio;
import com.cejasportafolio.mgb.repositorio.IPersonaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaServicio implements IPersonaServicio {
    @Autowired IPersonaRepositorio ipersonaRepositorio; 
    
    @Override
    public List<persona> getpersona() {
        List<persona> persona = ipersonaRepositorio.findAll();
                return persona;
    }

    @Override
    public void savePersona(persona persona) {
        ipersonaRepositorio.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepositorio.deleteById(id);
    }

    @Override
    public persona findPersona(Long id) {
        persona persona = ipersonaRepositorio.findById(id).orElse(null);
        return persona;
    }
    
}
