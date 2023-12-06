package com.gestionTrabajos.registro;

import java.util.List;

import com.gestionTrabajos.Anteproyecto.clsAnteproyecto;

public class UsuarioRegistroDTO {

	private Long id;
	private String email;
	private String password;
	private String usuario_nombres;
	private String usuario_apellidos;
	private int usuario_codigo;
	private List<clsAnteproyecto> anteproyectos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getUsuario_nombres() {
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

	public int getUsuario_codigo() {
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

	public UsuarioRegistroDTO(Long id, String email, String password, String usuario_nombres, String usuario_apellidos, int usuario_codigo, List<clsAnteproyecto> anteproyectos) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.usuario_nombres = usuario_nombres;
		this.usuario_apellidos = usuario_apellidos;
		this.usuario_codigo = usuario_codigo;
		this.anteproyectos = anteproyectos;
	}

	public UsuarioRegistroDTO() {
	}
}
