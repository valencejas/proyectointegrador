
package com.cejasportafolio.mgb.seguridad.entidad;

import com.cejasportafolio.mgb.seguridad.enumeracion.rolNombre;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private rolNombre rolNombre;
    //CONTRUCTOR 

    public rol() {
    }

    public rol(rolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    //getter y setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public rolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(rolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    Object getrolNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
