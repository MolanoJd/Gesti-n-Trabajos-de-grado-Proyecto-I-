package com.gestionTrabajos.registro;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gestionTrabajos.modelo.clsEstudiante;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        clsUsuario usuario = this.usuarioRepository.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        // Crea un objeto User sin roles
        UserDetails userDetails = new User(usuario.getEmail(), usuario.getPassword(), new ArrayList<>());

        return userDetails;
    }

}
