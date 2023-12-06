package com.gestionTrabajos.Usuario.controlador;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gestionTrabajos.Anteproyecto.AnteproyectoRepository;
import com.gestionTrabajos.modelo.clsEstudiante;
import com.gestionTrabajos.registro.UsuarioRegistroDTO;
import com.gestionTrabajos.registro.UsuarioRepository;
import com.gestionTrabajos.registro.UsuarioServicioImpl;
import com.gestionTrabajos.registro.clsUsuario;

import java.util.Optional;

class UsuarioServicioImplTest {

    @Mock
    private UsuarioRepository usuarioRepositoryMock;

    @Mock
    private AnteproyectoRepository anteproyectoRepositoryMock;

    @InjectMocks
    private UsuarioServicioImpl usuarioServicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGuardarEstudiante() {
        UsuarioRegistroDTO registroDTO = new UsuarioRegistroDTO(/* parametros */);
        clsEstudiante estudianteMock = new clsEstudiante(/* parametros */);
        when(usuarioRepositoryMock.save(any(clsEstudiante.class))).thenReturn(estudianteMock);

        clsUsuario result = usuarioServicio.guardarEstudiante(registroDTO);

        assertNotNull(result);
        assertEquals(estudianteMock.getEmail(), result.getEmail());
        // otros asserts relevantes
    }
/*
    @Test
    void testObtenerUsuario() {
        Long userId = 1L;
        String usuario_nombres = "Juan";
        clsUsuario usuarioMock = new clsUsuario(userId,usuario_nombres);
        when(usuarioRepositoryMock.findById(userId)).thenReturn(Optional.of(usuarioMock));

        Optional<clsUsuario> result = usuarioServicio.obtenerUsuario(userId);

        assertTrue(result.isPresent());
        assertEquals(userId, result.get().getId());
        // otros asserts relevantes
    }
    */

    @Test
    void testEliminarUsuario() {
        Long userId = 1L;
        
        doNothing().when(usuarioRepositoryMock).deleteById(userId);

        usuarioServicio.eliminarUsuario(userId);

        verify(usuarioRepositoryMock).deleteById(userId);
    }

    // Puedes agregar más pruebas para otros métodos
}
