package com.gestionTrabajos.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("DEPARTAMENTO")
@Table(name = "departamentos")
public class clsDepartamento extends clsJefeDepartamento {


	  public clsDepartamento() {
	        super();
	    }
	    public clsDepartamento(String nombres, String apellidos, String email, String password, int codigo) {
	        super(nombres, apellidos, email, password,codigo);
	    }

	    // Constructor con todos los campos
	    public clsDepartamento(Long id, String email, String password, String usuario_nombres, String usuario_apellidos, int usuario_codigo, String matricula, String carrera) {
	        super(id, email, password, usuario_nombres, usuario_apellidos, usuario_codigo, null);

	    }

	public clsDepartamento(String nombres, String apellidos, String email, String password) {
      super(nombres, apellidos, email, password);
  }

	@Column(name = "estado_operativo")
    private boolean estadoOperativo;

    public boolean isEstadoOperativo() {
        return estadoOperativo;
    }

    public void setEstadoOperativo(boolean estadoOperativo) {
        this.estadoOperativo = estadoOperativo;
    }
}
