package com.gestionTrabajos.registro;

import java.util.List;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gestionTrabajos.Anteproyecto.clsAnteproyecto;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	private UsuarioServicio usuarioServicio;

	private UsuarioRepository usuarioRepositorio;
	
    @Autowired
    public UsuarioController(UsuarioServicio usuarioServicio, UsuarioRepository usuarioRepositorio) {
        this.usuarioServicio = usuarioServicio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

	public UsuarioController(UsuarioServicio usuarioServicio) {
		super();
		this.usuarioServicio = usuarioServicio;
	}
	//este metodo sirve para actualizar empleado
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<clsUsuario> actualizarEmpleado(@PathVariable Long id, @RequestBody UsuarioRegistroDTO detallesUsuario) {
	    clsUsuario usuario = usuarioRepositorio.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));

	    // Actualizar los campos del usuario con los valores de detallesUsuario
	    usuario.setUsuario_nombres(detallesUsuario.getUsuario_nombres());
	    usuario.setUsuario_apellidos(detallesUsuario.getUsuario_apellidos());
	    usuario.setEmail(detallesUsuario.getEmail());

	    // Transformar clsUsuario en UsuarioRegistroDTO
	    UsuarioRegistroDTO usuarioDTO = new UsuarioRegistroDTO();
	    usuarioDTO.setUsuario_nombres(usuario.getDocente_nombres());
	    usuarioDTO.setUsuario_apellidos(usuario.getUsuario_apellidos());
	    usuarioDTO.setEmail(usuario.getEmail());

	    // Llamar al método guardarEstudiante con usuarioDTO
	    clsUsuario objUsuarioActualizado = usuarioServicio.guardarEstudiante(usuarioDTO);

	    return ResponseEntity.ok(objUsuarioActualizado);
	}


/*	@GetMapping("/formularioUsuarios")
	public String mostrarFormularioDeRegistro(Model model) {
	    model.addAttribute("usuario", new UsuarioRegistroDTO());
	    return "registro";
	}*/
	
	@GetMapping("/")
	public ResponseEntity<?>  listarUsuarios() {
	System.out.println("Entrado a listar usuarios");
	return ResponseEntity.ok(new LinkedHashSet<>(usuarioRepositorio.findAll()));
	}
	/*
	@PostMapping("/")
	public clsUsuario registrarCuentaDeUsuario(@RequestBody UsuarioRegistroDTO registroDTO) {
		clsUsuario objUsuarioCreado= usuarioServicio.guardarEstudiante(registroDTO);
		return objUsuarioCreado;
	}
	*/
	@PostMapping("/")
	public clsUsuario registrarCuentaDeUsuario(@RequestBody UsuarioRegistroDTO registroDTO, @RequestParam String rol) {
	    if (rol.equals("Estudiante")) {
	        return usuarioServicio.guardarEstudiante(registroDTO);
	    } else if (rol.equals("Jefe Departamento")) {
	        return usuarioServicio.guardarJefeDepartamento(registroDTO);
	    }else if(rol.equals("Director")) {
	    	return usuarioServicio.guardarDirector(registroDTO);
	    }else if(rol.equals("Jurado")) {
	    	return usuarioServicio.guardarJurado(registroDTO);	
	    }else if(rol.equals("Departamento")) {
	    	return usuarioServicio.guardarDepartamento(registroDTO);
	    }else if(rol.equals("Comite")) {
	    	return usuarioServicio.guardarComite(registroDTO);
	    }else if(rol.equals("Consejo")){
	    	return usuarioServicio.guardarConsejo(registroDTO);	    }
	    
	    return null;
	}

	
/*	@GetMapping("/{usuarioId}")
	public ResponseEntity<?> obtenerUsuario(@PathVariable("usuarioId") Long usuarioId) {
	    Optional<clsUsuario> usuarioOptional = usuarioServicio.obtenerUsuario(usuarioId);
	    
	    if (usuarioOptional.isPresent()) {
	        clsUsuario usuario = usuarioOptional.get();
	        return ResponseEntity.ok(usuario); // Devolver el usuario si se encontró
	    } else {
	        return ResponseEntity.notFound().build(); // Devolver una respuesta 404 si no se encontró
	    }
	}*/
	
	@GetMapping("/{usuarioId}")
	public ResponseEntity<?> obtenerUsuario(@PathVariable("usuarioId") Long usuarioId){
	    Optional<clsUsuario> usuarioOptional = usuarioServicio.obtenerUsuario(usuarioId);
	    
	    if (usuarioOptional.isPresent()) {
	        clsUsuario usuario = usuarioOptional.get();
	        return ResponseEntity.ok(usuario); // Devolver el usuario si se encontró
	    } else {
	        return ResponseEntity.notFound().build(); // Devolver una respuesta 404 si no se encontró
	    }
	}
    
    @GetMapping("/nombre/{nombre}")
    public clsUsuario obtenerUsuarioNombre(@PathVariable("username") String username){
        return usuarioServicio.obtenerUsuarioNombre(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
    	usuarioServicio.eliminarUsuario(usuarioId);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<clsUsuario> addProject(@PathVariable Long userId, @RequestParam String atrTitulo){
        
            System.out.println("userId: " + userId);
            System.out.println("atrTitulo: " + atrTitulo);

            // Agregar el proyecto al usuario
           // usuarioServicio.addProject(userId, atrTitulo);   
            // Devolver una respuesta exitosa (por ejemplo, código 201 Created)
            return ResponseEntity.ok(usuarioServicio.addProject(userId, atrTitulo));
    }
    
    @PutMapping("/{userId}/addFileToAnteproyecto") 
    public ResponseEntity<clsAnteproyecto> addFileToAnteproyecto(
        @PathVariable Long userId,
        @RequestParam String atrTitulo,
        @RequestPart("archivoAdjunto") MultipartFile archivoAdjunto
    ) {
        if (archivoAdjunto == null || archivoAdjunto.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        clsAnteproyecto anteproyecto = usuarioServicio.agregarArchivo(userId, atrTitulo, archivoAdjunto);

        if (anteproyecto != null) {
            return ResponseEntity.ok(anteproyecto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userId}/agregarComentario")
    public ResponseEntity<?> addCommentToAnteproyecto(@PathVariable Long userId, @RequestParam String atrTitulo, @RequestBody ComentarioRequest comentarioRequest) {
   
    	System.out.print("ENTRAMOS");

    	try {
        	//long numeroComoLong = Long.parseLong(numeroComoString);

        	System.out.print("ENTRAMOS");
            clsAnteproyecto anteproyecto = usuarioServicio.addCommentToAnteproyecto(
            		userId,atrTitulo,comentarioRequest.getComentario()
            );
            return ResponseEntity.ok(anteproyecto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar comentario: " + e.getMessage());
        }
    }

    public static class ComentarioRequest {

        private String comentario;

        // Constructor vacío
        public ComentarioRequest() {
        }

        // Constructor con todos los campos
        public ComentarioRequest( String comentario) {

            this.comentario = comentario;
        }

        // Getters


        public String getComentario() {
            return comentario;
        }

        // Setters

        public void setComentario(String comentario) {
            this.comentario = comentario;
        }

        // Puedes agregar aquí cualquier otro método que consideres necesario
    }

/*
    
    @PutMapping("/{userId}")
    public ResponseEntity<?> addProject(@PathVariable Long userId, @RequestParam String atrTitulo) {
        try {
            System.out.println("userId: " + userId);
            System.out.println("atrTitulo: " + atrTitulo);

            // Agregar el proyecto al usuario
            usuarioServicio.addProject(userId, atrTitulo);

            // Devolver una respuesta exitosa (código 201 Created) con un mensaje o cuerpo opcional
            return ResponseEntity.status(HttpStatus.CREATED).body("Proyecto agregado exitosamente.");
        } catch (NotFoundException e) {
            // Manejar la excepción de recurso no encontrado
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // Manejar otras excepciones
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }*/

}