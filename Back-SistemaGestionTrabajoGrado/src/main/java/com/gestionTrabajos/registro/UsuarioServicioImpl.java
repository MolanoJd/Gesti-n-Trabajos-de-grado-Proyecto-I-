package com.gestionTrabajos.registro;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestionTrabajos.modelo.clsEstudiante;


@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	private UsuarioRepository usuarioRepositorio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UsuarioServicioImpl(UsuarioRepository usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public clsUsuario guardarEstudiante(UsuarioRegistroDTO registroDTO) {
		clsEstudiante usuario = new clsEstudiante(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),passwordEncoder.encode(registroDTO.getPassword()));
		return usuarioRepositorio.save(usuario);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		clsUsuario usuario = usuarioRepositorio.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getEmail(), usuario.getPassword(), Arrays.asList(new SimpleGrantedAuthority(usuario.getClass().getSimpleName())));
	}
	
	@Override
	public List<clsUsuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}


	
}
