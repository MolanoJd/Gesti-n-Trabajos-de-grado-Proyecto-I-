package com.gestionTrabajos.modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "directores_proyecto")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class clsDirector extends clsUsuario {

    @ManyToOne
    @JoinColumn(name = "anteproyecto_id") 
    private clsAnteproyecto anteproyecto;
    
    public clsDirector() {
        super();
    }
}
