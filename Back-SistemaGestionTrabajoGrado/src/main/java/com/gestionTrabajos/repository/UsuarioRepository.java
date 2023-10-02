package com.gestionTrabajos.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionTrabajos.modelo.clsUsuario;

public interface UsuarioRepository extends JpaRepository<clsUsuario,Integer>{

}
