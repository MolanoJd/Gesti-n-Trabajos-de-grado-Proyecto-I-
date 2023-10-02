package com.gestionTrabajos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionTrabajos.modelo.clsAnteproyecto;
@Repository
public interface AnteproyectoRepository extends JpaRepository<clsAnteproyecto,Integer>{

}
