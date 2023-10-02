package com.gestionTrabajos.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "jefes_departamento")
public class clsJefeDepartamento extends clsUsuario {

    // Atributos específicos de clsJefeDepartamento, por ejemplo:
    // private String departamento;

    // Constructor vacío
    public clsJefeDepartamento() {
        super();
    }
}
