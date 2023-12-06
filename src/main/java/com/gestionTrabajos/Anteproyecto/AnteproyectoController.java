package com.gestionTrabajos.Anteproyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;

import com.gestionTrabajos.registro.JwtUtils;
import com.gestionTrabajos.registro.UsuarioRepository;
import com.gestionTrabajos.registro.clsUsuario;
import java.util.Set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.LinkedHashSet;

@RestController
@RequestMapping("/anteproyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class AnteproyectoController {

    private AnteproyectoRepository anteproyectoRepositorio;
    
	private UsuarioRepository usuarioRepositorio;

    @Autowired
    public AnteproyectoController(AnteproyectoRepository anteproyectoRepositorio, UsuarioRepository usuarioRepositorio) {
        this.anteproyectoRepositorio = anteproyectoRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

//AQUI PUEDE FALLAR

    
    @GetMapping("/")
    public ResponseEntity<?> listarAnteproyectos(){
        return ResponseEntity.ok(new LinkedHashSet<>(anteproyectoRepositorio.findAll()));
    }
    @GetMapping("/usuario/{email}")
    public ResponseEntity<?> listarAnteproyectosPorUsuario(@PathVariable String email) {
        // Buscar el usuario por email
        Optional<clsUsuario> usuarioOptional = Optional.ofNullable(usuarioRepositorio.findByEmail(email));

        if (usuarioOptional.isPresent()) {
            clsUsuario usuario = usuarioOptional.get();
            // Obtener los anteproyectos asociados con este usuario
            Set<clsAnteproyecto> anteproyectosDelUsuario = usuario.getAnteproyectos();

            return ResponseEntity.ok(new LinkedHashSet<>(anteproyectosDelUsuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    //MIRAR ESTUDIANTES
    @GetMapping("/usuario/id/{userID}")
    public ResponseEntity<?> listarAnteproyectosPorUsuarioID(@PathVariable Long userID) {
        // Buscar el usuario por email
        Optional<clsUsuario> usuarioOptional = usuarioRepositorio.findById(userID);

        if (usuarioOptional.isPresent()) {
            clsUsuario usuario = usuarioOptional.get();
            // Obtener los anteproyectos asociados con este usuario
            Set<clsAnteproyecto> anteproyectosDelUsuario = usuario.getAnteproyectos();

            return ResponseEntity.ok(new LinkedHashSet<>(anteproyectosDelUsuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<clsAnteproyecto> obtenerAnteproyecto(@PathVariable Long id) {
        clsAnteproyecto anteproyecto = anteproyectoRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el anteproyecto con el ID : " + id));
        return ResponseEntity.ok(anteproyecto);
    }
    
/*
    @PostMapping("/")
    public clsAnteproyecto crearAnteproyecto(@RequestBody clsAnteproyecto anteproyecto, @RequestHeader("Authorization") String token) {

        // Obtienes el usuario actual del contexto de seguridad
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Generas un token JWT para el usuario actual
        String tokenParaAnteproyecto = jwtUtils.generateToken(userDetails);

        // Guardas el token JWT del anteproyecto en la base de datos
        anteproyecto.setTokenJwt(tokenParaAnteproyecto);

        // Guardas el anteproyecto en la base de datos
        return anteproyectoRepositorio.save(anteproyecto);
    }*/
    
    @PostMapping("/")
    public ResponseEntity<clsAnteproyecto> crearAnteproyecto(@RequestBody clsAnteproyecto anteproyecto){
    	 clsAnteproyecto anteproyectoGuardado = anteproyectoRepositorio.save(anteproyecto);

         // Establecer estado y guardar nuevamente
         //anteproyectoGuardado.setAtrEstado("formato A");
         //anteproyectoGuardado = anteproyectoRepositorio.save(anteproyectoGuardado);

    	 Optional<clsUsuario> usuarioOptional = usuarioRepositorio.findById((long) 6);
    	 //Optional<clsUsuario> usuarioOptionalII = usuarioRepositorio.findById((long) 10);
    	//Optional<clsUsuario> usuarioOptional = Optional.ofNullable(usuarioRepositorio.findByDtype("FACULTAD"));
    	 if (usuarioOptional.isPresent()) {
    	        clsUsuario usuario = usuarioOptional.get();
    	   //     clsUsuario usuarioII = usuarioOptionalII.get();
    	        usuario.agregarAnteproyecto(anteproyectoGuardado);
    	     //   usuarioII.agregarAnteproyecto(anteproyectoGuardado);
    	        usuarioRepositorio.save(usuario);
    	       // usuarioRepositorio.save(usuarioII);// Guardar los cambios en el usuario
    	    }
        return ResponseEntity.ok(anteproyectoGuardado);
    }
    
    @PutMapping("/anteproyectos/{id}")
    public ResponseEntity<clsAnteproyecto> actualizarAnteproyecto(@PathVariable Long id, @RequestBody clsAnteproyecto detallesAnteproyecto) {
        clsAnteproyecto anteproyecto = anteproyectoRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el anteproyecto con el ID : " + id));

        // Actualizar los campos del anteproyecto con los valores de detallesAnteproyecto
        anteproyecto.setAtrTitulo(detallesAnteproyecto.getAtrTitulo());
        // Actualiza los demás atributos del anteproyecto de la misma manera

        // Llamar al método para guardar el anteproyecto actualizado
        clsAnteproyecto anteproyectoActualizado = anteproyectoRepositorio.save(anteproyecto);
        
        return ResponseEntity.ok(anteproyectoActualizado);
    }

    @DeleteMapping("/anteproyectos/{id}")
    public ResponseEntity<Void> eliminarAnteproyecto(@PathVariable Long id) {
        clsAnteproyecto anteproyecto = anteproyectoRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el anteproyecto con el ID : " + id));
        anteproyectoRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
