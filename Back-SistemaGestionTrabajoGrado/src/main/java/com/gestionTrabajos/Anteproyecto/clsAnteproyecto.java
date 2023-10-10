package com.gestionTrabajos.Anteproyecto;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gestionTrabajos.modelo.clsRevision;
import com.gestionTrabajos.registro.clsUsuario;

@Entity
@Table(name = "anteproyectos")
public class clsAnteproyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String atrTitulo;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id") // Nombre de la columna que establece la relación
    private clsUsuario usuario;

	@Column(nullable = false)
	private Integer atrContraseña;
	
	@OneToMany(mappedBy = "anteproyecto")
	private List<clsRevision> revisiones;


	@ElementCollection
	@CollectionTable(name = "anteproyecto_comentarios", joinColumns = @JoinColumn(name = "anteproyecto_id"))
	@Column(name = "comentario")
	private List<String> comentarios;


    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    public void agregarComentario(String comentario) {
        this.comentarios.add(comentario);
    }
	public Integer getAtrIdentificador() {
		return id;
	}

	public void setAtrIdentificador(Integer atrIdentificador) {
		this.id = atrIdentificador;
	}

	public String getAtrTitulo() {
		return atrTitulo;
	}

	public void setAtrTitulo(String atrTitulo) {
		this.atrTitulo = atrTitulo;
	}

	public Integer getAtrContraseña() {
		return atrContraseña;
	}

	public void setAtrContraseña(Integer atrContraseña) {
		this.atrContraseña = atrContraseña;
	}

}
