package com.gestionTrabajos.registro;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionTrabajos.modelo.clsEstudiante;


public interface UsuarioRepository extends JpaRepository<clsUsuario,Long>{
	public clsUsuario findByEmail(String email);
	//public clsUsuario save(UsuarioRegistroDTO registroDTO);
}
