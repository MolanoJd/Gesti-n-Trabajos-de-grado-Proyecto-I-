package com.gestionTrabajos.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import com.gestionTrabajos.registro.clsUsuario;

@Entity
@DiscriminatorValue("DIRECTOR")
@Table(name = "directores_proyecto")
public class clsDirector extends clsUsuario {
	  public clsDirector() {
	        super();
	    }
	    public clsDirector(String nombres, String apellidos, String email, String password, int codigo) {
	        super(nombres, apellidos, email, password,codigo);
	    }

	    // Constructor con todos los campos
	    public clsDirector(Long id, String email, String password, String usuario_nombres, String usuario_apellidos, int usuario_codigo, String matricula, String carrera) {
	        super(id, email, password, usuario_nombres, usuario_apellidos, usuario_codigo, null);

	    }

}
