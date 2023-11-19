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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashSet;

@RestController
@RequestMapping("/anteproyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class AnteproyectoController {

    private AnteproyectoRepository anteproyectoRepositorio;

    @Autowired
    public AnteproyectoController(AnteproyectoRepository anteproyectoRepositorio) {
        this.anteproyectoRepositorio = anteproyectoRepositorio;
    }
//AQUI PUEDE FALLAR

    
    @GetMapping("/")
    public ResponseEntity<?> listarAnteproyectos(){
        return ResponseEntity.ok(new LinkedHashSet<>(anteproyectoRepositorio.findAll()));
    }


    @GetMapping("/anteproyectos/{id}")
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
