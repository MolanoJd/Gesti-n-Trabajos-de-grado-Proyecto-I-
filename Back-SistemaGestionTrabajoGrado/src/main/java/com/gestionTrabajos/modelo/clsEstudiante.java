package com.gestionTrabajos.modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "estudiantes")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class clsEstudiante extends clsUsuario {

    // Atributos específicos de clsEstudiante
    // private String matricula;
    // private String carrera;

    // Constructor vacío
    public clsEstudiante() {
        super();
    }

    // Constructor con parámetros específicos de clsEstudiante (y también puedes incluir los de clsUsuario si lo deseas)


    // Getters y setters para los atributos específicos de clsEstudiante
    /*
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    */

    // ... otros métodos específicos de clsEstudiante ...

}
