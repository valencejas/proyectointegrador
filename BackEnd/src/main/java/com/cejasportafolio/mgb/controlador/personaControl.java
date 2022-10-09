/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cejasportafolio.mgb.controlador;

import com.cejasportafolio.mgb.entidad.persona;
import com.cejasportafolio.mgb.interfaz.IPersonaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class personaControl {
    @Autowired IPersonaServicio ipersonaServicio;
    
    @GetMapping("/persona/traer/perfil")
    public List<persona> getpersona(){
        return ipersonaServicio.getpersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona/crear")
    public String createpersona(@RequestBody persona persona){
        ipersonaServicio.savePersona(persona);
        return "La persona fue creada con exito";
    }
     @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/borrar/id")
    public String deletepersona(@PathVariable Long id){
        ipersonaServicio.deletePersona(id);
        return "La persona fue eliminada con exito";
    }
     @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persona/editar/id")
    public persona editpersona(@PathVariable Long id,
                              @RequestParam("nombre") String nuevoNombre,
                              @RequestParam("apellido") String nuevoApellido,
                              @RequestParam("img") String nuevoImg){
        persona persona = ipersonaServicio.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        ipersonaServicio.savePersona(persona);
        return persona;
    }
        
}
