package com.gestionTrabajos.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.gestionTrabajos.registro.UsuarioRegistroDTO;
import com.gestionTrabajos.registro.clsUsuario;

@Entity
@DiscriminatorValue("FACULTAD")
@Table(name = "consejo")
public class clsConsejoFacultad extends clsUsuario{
	 public clsConsejoFacultad() {
	        super();
	    }
	    public clsConsejoFacultad(String nombres, String apellidos, String email, String password, int codigo) {
	        super(nombres, apellidos, email, password,codigo);
	    }

	    // Constructor con todos los campos
	    public clsConsejoFacultad(Long id, String email, String password, String usuario_nombres, String usuario_apellidos, int usuario_codigo, String matricula, String carrera) {
	        super(id, email, password, usuario_nombres, usuario_apellidos, usuario_codigo, null);
	    }

}
