package com.gestionTrabajos.Anteproyecto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnteproyectoRepository extends JpaRepository<clsAnteproyecto,Long>{
	clsAnteproyecto findByAtrTitulo(String atrTitulo);
}
