package com.gestionTrabajos.modelo;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gestionTrabajos.Anteproyecto.clsAnteproyecto;
import com.gestionTrabajos.registro.clsUsuario;

@Entity
@DiscriminatorValue("JEFEDEPARTAMENTO")
@Table(name = "jefes_departamento")
public class clsJefeDepartamento extends clsUsuario {

    public clsJefeDepartamento(String nombres, String apellidos, String email, String password, int codigo) {
        super(nombres, apellidos, email, password, codigo);
    }
    public clsJefeDepartamento(Long id, String email, String password, String usuario_nombres, String usuario_apellidos, int usuario_codigo, String matricula, String carrera) {
        super(id, email, password, usuario_nombres, usuario_apellidos, usuario_codigo, null);
    }
	public clsJefeDepartamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public clsJefeDepartamento(Long id, String email, String password, String usuario_nombres, String usuario_apellidos,
			int usuario_codigo, Set<clsAnteproyecto> anteproyectos) {
		super(id, email, password, usuario_nombres, usuario_apellidos, usuario_codigo, anteproyectos);
		// TODO Auto-generated constructor stub
	}
	public clsJefeDepartamento(Long id, String email, String password, String usuario_nombres, String usuario_apellidos,
			int usuario_codigo) {
		super(id, email, password, usuario_nombres, usuario_apellidos, usuario_codigo);
		// TODO Auto-generated constructor stub
	}
	public clsJefeDepartamento(Long id, String email, String password) {
		super(id, email, password);
		// TODO Auto-generated constructor stub
	}
	public clsJefeDepartamento(Long id, String usuario_nombres) {
		super(id, usuario_nombres);
		// TODO Auto-generated constructor stub
	}
	public clsJefeDepartamento(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	public clsJefeDepartamento(String usuario_nombres, String usuario_apellidos, String email, String password) {
		super(usuario_nombres, usuario_apellidos, email, password);
		// TODO Auto-generated constructor stub
	}
    
}
