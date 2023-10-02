package com.gestionTrabajos.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "jurados")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class clsJurado extends clsUsuario {
    public clsJurado() {
        super();
    }
    
    @OneToMany(mappedBy = "jurado")
    private List<clsRevision> revisiones;

}
