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
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import com.gestionTrabajos.registro.JwtUtils;
import com.gestionTrabajos.registro.clsUsuario;
import com.gestionTrabajos.revision.clsRevision;

@Entity
@Table(name = "anteproyectos")
public class clsAnteproyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(length = 250, nullable = false, unique = true)
	private String atrTitulo;
    
	   @ManyToMany(mappedBy = "anteproyectos")
	    private Set<clsUsuario> usuarios = new HashSet<>();

	@OneToMany(mappedBy = "anteproyecto")
	private List<clsRevision> revisiones;


	@ElementCollection
	@CollectionTable(name = "anteproyecto_comentarios", joinColumns = @JoinColumn(name = "anteproyecto_id"))
	@Column(name = "comentario")
	private List<String> comentarios;
	
	 private String tokenJwt;

	/*    @Transient // Esta anotación indica que el campo no será persistido en la base de datos
	    private MultipartFile archivoAdjunto;

	    // Resto de atributos y métodos de la entidad

	    public MultipartFile getArchivoAdjunto() {
	        return archivoAdjunto;
	    }

	    public void setArchivoAdjunto(MultipartFile archivoAdjunto) {
	        this.archivoAdjunto = archivoAdjunto;
	    }

*/
	 @Transient
	 private String archivoAdjunto; // Cambiar el tipo a String para guardar la ruta del archivo

	    public void setArchivoAdjunto(String filePath) {
	        this.archivoAdjunto = filePath;
	    }

	    // Actualiza el getter para obtener la cadena
	    public String getArchivoAdjunto() {
	        return archivoAdjunto;
	    }

	 

	    public void setTokenJwt(String tokenJwt) {
	        this.tokenJwt = tokenJwt;
	    }

	    public String getTokenJwt() {
	        return tokenJwt;
	    }
	

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    public void agregarComentario(String comentario) {
        this.comentarios.add(comentario);
    }
	public Long getAtrIdentificador() {
		return id;
	}

	public void setAtrIdentificador(Long atrIdentificador) {
		this.id = atrIdentificador;
	}

	public String getAtrTitulo() {
		return atrTitulo;
	}

	public void setAtrTitulo(String atrTitulo) {
		this.atrTitulo = atrTitulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<clsUsuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<clsUsuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<clsRevision> getRevisiones() {
		return revisiones;
	}

	public void setRevisiones(List<clsRevision> revisiones) {
		this.revisiones = revisiones;
	}



}