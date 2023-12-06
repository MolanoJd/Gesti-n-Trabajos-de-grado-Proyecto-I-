package com.gestionTrabajos.registro;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionTrabajos.modelo.clsEstudiante;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<clsUsuario,Long>{
	public clsUsuario findByEmail(String email);
	public clsUsuario findByDtype(String dtype);
	//public clsUsuario save(UsuarioRegistroDTO registroDTO);
}
