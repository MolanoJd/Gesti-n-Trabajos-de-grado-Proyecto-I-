package com.gestionTrabajos.registro;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;




public interface UsuarioServicio extends UserDetailsService{

	public clsUsuario guardarEstudiante(UsuarioRegistroDTO registroDTO);
	
	public List<clsUsuario> listarUsuarios();
	
}
