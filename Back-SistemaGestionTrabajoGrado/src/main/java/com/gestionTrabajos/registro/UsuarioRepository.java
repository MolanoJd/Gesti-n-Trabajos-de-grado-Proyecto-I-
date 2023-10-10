package com.gestionTrabajos.registro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<clsUsuario,Integer>{
	public clsUsuario findByEmail(String email);

	//public clsUsuario save(UsuarioRegistroDTO registroDTO);
}
