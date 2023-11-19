package com.gestionTrabajos.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gestionTrabajos.registro.clsUsuario;

@Entity
@DiscriminatorValue("JEFEDEPARTAMENTO")
@Table(name = "jefes_departamento")
public class clsJefeDepartamento extends clsUsuario {

    // Atributos específicos de clsJefeDepartamento, por ejemplo:
    // private String departamento;
}
