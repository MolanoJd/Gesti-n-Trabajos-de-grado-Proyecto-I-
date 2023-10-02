package com.gestionTrabajos.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")

public class clsUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String email;

	@Column(length = 10, nullable = false)
	private String password;
	
	@Column(name = "nombre", length = 60, nullable = false)
	public String usuario_nombres;
	
	@Column(name = "apellido", length = 60, nullable = false)
	private String usuario_apellidos;

	@Column(name = "codigo", columnDefinition = "INT(15)")
	private int usuario_codigo;

    @OneToMany(mappedBy = "usuario") // "usuario" se refiere al nombre del atributo en clsAnteproyecto
    private List<clsAnteproyecto> anteproyectos;


	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDocente_nombres() {
		return usuario_nombres;
	}

	public void setUsuario_nombres(String usuario_nombres) {
		this.usuario_nombres = usuario_nombres;
	}

	public String getUsuario_apellidos() {
		return usuario_apellidos;
	}

	public void setUsuario_apellidos(String usuario_apellidos) {
		this.usuario_apellidos = usuario_apellidos;
	}

	
	public int get_Usuario_codigo() {
		return usuario_codigo;
	}

	public void setUsuario_codigo(int usuario_codigo) {
		this.usuario_codigo = usuario_codigo;
	}
	public List<clsAnteproyecto> getAnteproyectos() {
        return anteproyectos;
    }

    public void setAnteproyectos(List<clsAnteproyecto> anteproyectos) {
        this.anteproyectos = anteproyectos;
    }

}
