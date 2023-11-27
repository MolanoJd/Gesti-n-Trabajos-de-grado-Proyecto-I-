package com.gestionTrabajos.revision;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestionTrabajos.Anteproyecto.clsAnteproyecto;
import com.gestionTrabajos.modelo.clsJurado;

@Entity
@Table(name = "revisiones")
public class clsRevision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
        name = "revision_jurado", 
        joinColumns = @JoinColumn(name = "revision_id"), 
        inverseJoinColumns = @JoinColumn(name = "jurado_id")
    )
    private Set<clsJurado> jurados;

    @ManyToOne
    private clsAnteproyecto anteproyecto;

    // Otros atributos y métodos

}
