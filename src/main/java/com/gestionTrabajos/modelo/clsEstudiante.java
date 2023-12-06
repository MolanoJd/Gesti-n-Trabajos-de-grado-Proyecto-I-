package com.gestionTrabajos.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.gestionTrabajos.registro.UsuarioRegistroDTO;
import com.gestionTrabajos.registro.clsUsuario;

@Entity
@DiscriminatorValue("ESTUDIANTE")
@Table(name = "estudiantes")
public class clsEstudiante extends clsUsuario {

    // Atributos específicos de clsEstudiante
    private String matricula;
    private String carrera;

    // Constructor vacío
    public clsEstudiante() {
        super();
    }
    public clsEstudiante(String nombres, String apellidos, String email, String password, int codigo) {
        super(nombres, apellidos, email, password,codigo);
    }
    public clsEstudiante(String nombres, String apellidos, String email, String password, int codigo,String dtype) {
        super(nombres, apellidos, email, password,codigo,dtype);
    }

    // Constructor con campos específicos
    public clsEstudiante(String matricula, String carrera) {
        this.matricula = matricula;
        this.carrera = carrera;
    }

    // Getters y setters para los atributos específicos de clsEstudiante
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
    
 


}
