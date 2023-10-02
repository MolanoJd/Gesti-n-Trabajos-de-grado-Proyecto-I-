package com.gestionTrabajos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "departamentos")
public class clsDepartamento extends clsJefeDepartamento {

    @Column(name = "estado", nullable = false)
    private boolean estadoOperativo; // true si el departamento puede realizar operaciones, false en caso contrario

    public clsDepartamento() {
        super();
    }

    public boolean isEstadoOperativo() {
        return estadoOperativo;
    }

    public void setEstadoOperativo(boolean estadoOperativo) {
        this.estadoOperativo = estadoOperativo;
    }
}
