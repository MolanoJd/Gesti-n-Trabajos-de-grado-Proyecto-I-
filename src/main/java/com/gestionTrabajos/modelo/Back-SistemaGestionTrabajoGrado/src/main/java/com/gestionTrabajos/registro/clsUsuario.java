package com.gestionTrabajos.registro;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestionTrabajos.Anteproyecto.clsAnteproyecto;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@Builder
public abstract class clsUsuario{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(length = 45, nullable = false, unique = true)
	protected String email;

	@Column(length = 200, nullable = false)
	protected String password;
	
	@Column(name = "nombre", length = 60, nullable = false)
	protected String usuario_nombres;
	
	@Column(name = "apellido", length = 60, nullable = false)
	protected String usuario_apellidos;

	@Column(name = "codigo", columnDefinition = "INT(15)")
	protected int usuario_codigo;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
        name = "usuario_anteproyecto",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "anteproyecto_id")
    )
    protected Set<clsAnteproyecto> anteproyectos = new HashSet<>();



	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDocente_nombres() {
		return usuario_nombres;
	}

	public void setUsuario_nombres(String usuario_nombres) {
		this.usuario_nombres = usuario_nombres;
	}

	public String getUsuario_apellidos() {
		return usuario_apellidos;
	}

	public void setUsuario_apellidos(String usuario_apellidos) {
		this.usuario_apellidos = usuario_apellidos;
	}

	
	public int get_Usuario_codigo() {
		return usuario_codigo;
	}

	public void setUsuario_codigo(int usuario_codigo) {
		this.usuario_codigo = usuario_codigo;
	}
	public Set<clsAnteproyecto> getAnteproyectos() {
        return anteproyectos;
    }


	public clsUsuario(Long id) {
		super();
		this.id = id;
	}

	public clsUsuario(Long id, String usuario_nombres) {
		super();
		this.id = id;
		this.usuario_nombres = usuario_nombres;
	}

	public clsUsuario(Long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public clsUsuario(Long id, String email, String password, String usuario_nombres, String usuario_apellidos,
			int usuario_codigo, Set<clsAnteproyecto> anteproyectos) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.usuario_nombres = usuario_nombres;
		this.usuario_apellidos = usuario_apellidos;
		this.usuario_codigo = usuario_codigo;
		this.anteproyectos = anteproyectos;
	}
	

	public clsUsuario(Long id, String email, String password, String usuario_nombres, String usuario_apellidos,
			int usuario_codigo) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.usuario_nombres = usuario_nombres;
		this.usuario_apellidos = usuario_apellidos;
		this.usuario_codigo = usuario_codigo;
	}


	public clsUsuario(String usuario_nombres, String usuario_apellidos,String email, String password) {
		super();
		this.email = email;
		this.password = password;
		this.usuario_nombres = usuario_nombres;
		this.usuario_apellidos = usuario_apellidos;
	}
	
	public clsUsuario(String usuario_nombres, String usuario_apellidos,String email, String password,int usuario_codigo) {
		super();
		this.email = email;
		this.password = password;
		this.usuario_nombres = usuario_nombres;
		this.usuario_apellidos = usuario_apellidos;
		this.usuario_codigo = usuario_codigo;
	}

	public clsUsuario() {
		
	}
	
	public void setAnteproyectos(Set<clsAnteproyecto> anteproyectos) {
        this.anteproyectos = anteproyectos;
    }
	public void agregarAnteproyecto(clsAnteproyecto anteproyectos) {
        this.anteproyectos.add(anteproyectos);
    }
	   public UsuarioRegistroDTO toDTO() {
	        UsuarioRegistroDTO usuarioDTO = new UsuarioRegistroDTO();
	        usuarioDTO.setId(this.getId());
	        usuarioDTO.setEmail(this.getEmail());
	        usuarioDTO.setPassword(this.getPassword());
	        usuarioDTO.setUsuario_nombres(this.getDocente_nombres());
	        usuarioDTO.setUsuario_apellidos(this.getUsuario_apellidos());
	  
	        return usuarioDTO;
	    }
}
