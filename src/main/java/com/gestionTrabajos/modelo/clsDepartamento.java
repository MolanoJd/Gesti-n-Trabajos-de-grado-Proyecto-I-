package com.gestionTrabajos.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("DEPARTAMENTO")
@Table(name = "departamentos")
public class clsDepartamento extends clsJefeDepartamento {

    @Column(name = "estado_operativo")
    private boolean estadoOperativo;

    public boolean isEstadoOperativo() {
        return estadoOperativo;
    }

    public void setEstadoOperativo(boolean estadoOperativo) {
        this.estadoOperativo = estadoOperativo;
    }
}
