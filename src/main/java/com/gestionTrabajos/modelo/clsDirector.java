package com.gestionTrabajos.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import com.gestionTrabajos.registro.clsUsuario;

@Entity
@DiscriminatorValue("DIRECTOR")
@Table(name = "directores_proyecto")
public class clsDirector extends clsUsuario {

}
