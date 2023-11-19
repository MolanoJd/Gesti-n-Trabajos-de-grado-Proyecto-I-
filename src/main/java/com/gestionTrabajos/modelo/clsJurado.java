package com.gestionTrabajos.modelo;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.gestionTrabajos.registro.clsUsuario;
import com.gestionTrabajos.revision.clsRevision;

@Entity
@DiscriminatorValue("JURADO")
@Table(name = "jurados")
public class clsJurado extends clsUsuario {
    
    @OneToMany(mappedBy = "jurado")
    private List<clsRevision> revisiones;

}
