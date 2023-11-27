package com.gestionTrabajos.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.Set;

import com.gestionTrabajos.registro.clsUsuario;
import com.gestionTrabajos.revision.clsRevision;

@Entity
@DiscriminatorValue("JURADO")
@Table(name = "jurados")
public class clsJurado extends clsUsuario{

	  public clsJurado() {
	        super();
	    }
	    public clsJurado(String nombres, String apellidos, String email, String password, int codigo) {
	        super(nombres, apellidos, email, password,codigo);
	    }

	    // Constructor con todos los campos
	    public clsJurado(Long id, String email, String password, String usuario_nombres, String usuario_apellidos, int usuario_codigo, String matricula, String carrera) {
	        super(id, email, password, usuario_nombres, usuario_apellidos, usuario_codigo, null);

	    }

	public clsJurado(String nombres, String apellidos, String email, String password) {
        super(nombres, apellidos, email, password);
    }


    @ManyToMany(mappedBy = "jurados")
    private Set<clsRevision> revisiones;

    // Otros atributos y métodos

}
