// Clase clsRevision

package com.gestionTrabajos.revision;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gestionTrabajos.Anteproyecto.clsAnteproyecto;
import com.gestionTrabajos.modelo.clsJurado;

@Entity
@Table(name = "revisiones")
public class clsRevision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private clsJurado jurado;

    @ManyToOne
    private clsAnteproyecto anteproyecto;

    // Otros atributos de la revisión, por ejemplo:
    // private String comentarios;
    // private Date fechaRevision;

    // Constructor, getters, setters, etc.

}
