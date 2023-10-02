package com.gestionTrabajos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gestionTrabajos.modelo.clsAnteproyecto;
import com.gestionTrabajos.modelo.clsUsuario;
import com.gestionTrabajos.repository.UsuarioRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository; // Asumiendo que tienes un repositorio para clsUsuario

    /**
     * Método para consultar si un usuario tiene un anteproyecto específico.
     * @param usuarioId El ID del usuario.
     * @param nombreAnteproyecto El nombre del anteproyecto a buscar.
     * @return true si el usuario tiene el anteproyecto especificado, false en caso contrario.
     */
    @GetMapping("/usuario/consultarAnteproyecto")
    @ResponseBody
    public boolean consultarAnteproyecto(@RequestParam Integer usuarioId, @RequestParam String nombreAnteproyecto) {
        clsUsuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (usuario != null) {
            List<clsAnteproyecto> anteproyectos = usuario.getAnteproyectos();
            for (clsAnteproyecto anteproyecto : anteproyectos) {
                if (anteproyecto.getAtrTitulo().equals(nombreAnteproyecto)) {
                    return true;
                }
            }
        }
        return false;
    }
    // Obtener todos los usuarios
    @GetMapping
    public List<clsUsuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<clsUsuario> obtenerUsuarioPorId(@PathVariable Integer id) {
        java.util.Optional<clsUsuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo usuario
    @PostMapping
    public clsUsuario crearUsuario(@RequestBody clsUsuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<clsUsuario> actualizarUsuario(@PathVariable Integer id, @RequestBody clsUsuario usuarioActualizado) {
        java.util.Optional<clsUsuario> usuario = usuarioRepository.findById(id);
        if (((java.util.Optional<clsUsuario>) usuario).isPresent()) {
            usuarioActualizado.setId(id);
            return ResponseEntity.ok(usuarioRepository.save(usuarioActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
