package com.gestionTrabajos.registro;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gestionTrabajos.modelo.clsEstudiante;

@Component
public class ClsEstudianteToUsuarioRegistroDTOConverter implements Converter<clsEstudiante, UsuarioRegistroDTO> {

    @Override
    public UsuarioRegistroDTO convert(clsEstudiante clsEstudiante) {
        UsuarioRegistroDTO usuarioRegistroDTO = new UsuarioRegistroDTO();
        // Realiza la conversión de clsEstudiante a UsuarioRegistroDTO aquí
        // Por ejemplo, puedes copiar los campos uno a uno o realizar una conversión personalizada

        usuarioRegistroDTO.setUsuario_nombres(clsEstudiante.getDocente_nombres());
        usuarioRegistroDTO.setUsuario_apellidos(clsEstudiante.getUsuario_apellidos());
        usuarioRegistroDTO.setEmail(clsEstudiante.getEmail());
        usuarioRegistroDTO.setPassword(clsEstudiante.getPassword());
        
        return usuarioRegistroDTO;
    }
}
