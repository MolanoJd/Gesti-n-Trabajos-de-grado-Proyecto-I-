package com.gestionTrabajos.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import com.gestionTrabajos.registro.clsUsuario;

@Entity
@DiscriminatorValue("ASESOR")
@Table(name = "asesores_proyecto")
public class clsAsesor extends clsUsuario {
	  public clsAsesor() {
	        super();
	    }
	    public clsAsesor(String nombres, String apellidos, String email, String password, int codigo) {
	        super(nombres, apellidos, email, password,codigo);
	    }

	    public clsAsesor(String nombres, String apellidos, String email, String password, int codigo,String dtype) {
	        super(nombres, apellidos, email, password,codigo,dtype);
	    }

}