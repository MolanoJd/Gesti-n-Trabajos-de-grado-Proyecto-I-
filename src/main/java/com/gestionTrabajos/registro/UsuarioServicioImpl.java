package com.gestionTrabajos.registro;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import org.apache.commons.lang3.StringUtils;

import org.springframework.util.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.gestionTrabajos.Anteproyecto.AnteproyectoRepository;
import com.gestionTrabajos.Anteproyecto.clsAnteproyecto;
import com.gestionTrabajos.modelo.clsAsesor;
import com.gestionTrabajos.modelo.clsComite;
import com.gestionTrabajos.modelo.clsConsejoFacultad;
import com.gestionTrabajos.modelo.clsDepartamento;
import com.gestionTrabajos.modelo.clsDirector;
import com.gestionTrabajos.modelo.clsEstudiante;
import com.gestionTrabajos.modelo.clsJefeDepartamento;
import com.gestionTrabajos.modelo.clsJurado;



@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	private UsuarioRepository usuarioRepositorio;
	@Autowired
	private AnteproyectoRepository anteproyectoRepositorio;
	
	@Autowired
	private ServletContext servletContext;

	@Value("${file.upload.path}") // Puedes configurar esta propiedad en tu archivo application.properties
	private String fileUploadPath;


	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;
	

	public UsuarioServicioImpl(UsuarioRepository usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

/*	@Override
	public clsUsuario guardarEstudiante(clsUsuario registroDTO) {
		clsEstudiante usuario = new clsEstudiante(registroDTO.getDocente_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),passwordEncoder.encode(registroDTO.getPassword()));
		return usuarioRepositorio.save(usuario);

	}
*/
	/*
	@Override
	public clsUsuario guardarEstudiante(UsuarioRegistroDTO registroDTO) {
		clsEstudiante usuario = new clsEstudiante(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),passwordEncoder.encode(registroDTO.getPassword()),registroDTO.getUsuario_codigo());
		usuario.setDtype("ESTUDIANTE");
		return usuarioRepositorio.save(usuario);
	}
	@Override
	public clsUsuario guardarJefeDepartamento(UsuarioRegistroDTO registroDTO) {
		System.out.printf("Codigo", registroDTO.getUsuario_codigo());
		clsJefeDepartamento usuario = new clsJefeDepartamento(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),passwordEncoder.encode(registroDTO.getPassword()), registroDTO.getUsuario_codigo());
		usuario.setDtype("JEFEDEPARTAMENTO");
		return usuarioRepositorio.save(usuario);
	}
	@Override
	public clsUsuario guardarDirector(UsuarioRegistroDTO registroDTO) {
		System.out.printf("Codigo", registroDTO.getUsuario_codigo());
		clsDirector usuario = new clsDirector(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),passwordEncoder.encode(registroDTO.getPassword()), registroDTO.getUsuario_codigo());
		usuario.setDtype("DIRECTOR");
		return usuarioRepositorio.save(usuario);
	}
	@Override
	public clsUsuario guardarJurado(UsuarioRegistroDTO registroDTO) {
		System.out.printf("Codigo", registroDTO.getUsuario_codigo());
		clsJurado usuario = new clsJurado(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),passwordEncoder.encode(registroDTO.getPassword()), registroDTO.getUsuario_codigo());
		usuario.setDtype("JURADO");
		
		return usuarioRepositorio.save(usuario);
	}
	@Override
	public clsUsuario guardarDepartamento(UsuarioRegistroDTO registroDTO) {
		System.out.printf("Codigo", registroDTO.getUsuario_codigo());
		clsDepartamento usuario = new clsDepartamento(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),passwordEncoder.encode(registroDTO.getPassword()), registroDTO.getUsuario_codigo());
		usuario.setDtype("DEPARTAMENTO");

		return usuarioRepositorio.save(usuario);
	}
	@Override
	public clsUsuario guardarComite(UsuarioRegistroDTO registroDTO) {
		System.out.printf("Codigo", registroDTO.getUsuario_codigo());
		clsComite usuario = new clsComite(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),passwordEncoder.encode(registroDTO.getPassword()), registroDTO.getUsuario_codigo());
		usuario.setDtype("COMITE");

		return usuarioRepositorio.save(usuario);
	}
	@Override
	public clsUsuario guardarConsejo(UsuarioRegistroDTO registroDTO) {
		System.out.printf("Codigo", registroDTO.getUsuario_codigo());
		clsConsejoFacultad usuario = new clsConsejoFacultad(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),passwordEncoder.encode(registroDTO.getPassword()), registroDTO.getUsuario_codigo(),registroDTO.getDtype());
		usuario.setDtype("FACULTAD");
		return usuarioRepositorio.save(usuario);
	}
	*/
	
	@Override
	public clsUsuario guardarEstudiante(UsuarioRegistroDTO registroDTO) {
		clsEstudiante usuario = new clsEstudiante(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),registroDTO.getPassword(),registroDTO.getUsuario_codigo());
		usuario.setDtype("ESTUDIANTE");
		return usuarioRepositorio.save(usuario);
	}
	@Override
	public clsUsuario guardarJefeDepartamento(UsuarioRegistroDTO registroDTO) {
		System.out.printf("Codigo", registroDTO.getUsuario_codigo());
		clsJefeDepartamento usuario = new clsJefeDepartamento(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),registroDTO.getPassword(), registroDTO.getUsuario_codigo());
		usuario.setDtype("JEFEDEPARTAMENTO");
		return usuarioRepositorio.save(usuario);
	}
	@Override
	public clsUsuario guardarDirector(UsuarioRegistroDTO registroDTO) {
		System.out.printf("Codigo", registroDTO.getUsuario_codigo());
		clsDirector usuario = new clsDirector(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),registroDTO.getPassword(), registroDTO.getUsuario_codigo());
		usuario.setDtype("DIRECTOR");
		return usuarioRepositorio.save(usuario);
	}
	@Override
	public clsUsuario guardarAsesor(UsuarioRegistroDTO registroDTO) {
		System.out.printf("Codigo", registroDTO.getUsuario_codigo());
		clsAsesor usuario = new clsAsesor(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),registroDTO.getPassword(), registroDTO.getUsuario_codigo());
		usuario.setDtype("ASESOR");
		return usuarioRepositorio.save(usuario);
	}
	@Override
	public clsUsuario guardarJurado(UsuarioRegistroDTO registroDTO) {
		System.out.printf("Codigo", registroDTO.getUsuario_codigo());
		clsJurado usuario = new clsJurado(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),registroDTO.getPassword(), registroDTO.getUsuario_codigo());
		usuario.setDtype("JURADO");
		
		return usuarioRepositorio.save(usuario);
	}
	@Override
	public clsUsuario guardarDepartamento(UsuarioRegistroDTO registroDTO) {
		System.out.printf("Codigo", registroDTO.getUsuario_codigo());
		clsDepartamento usuario = new clsDepartamento(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),registroDTO.getPassword(), registroDTO.getUsuario_codigo());
		usuario.setDtype("DEPARTAMENTO");

		return usuarioRepositorio.save(usuario);
	}
	@Override
	public clsUsuario guardarComite(UsuarioRegistroDTO registroDTO) {
		System.out.printf("Codigo", registroDTO.getUsuario_codigo());
		clsComite usuario = new clsComite(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),registroDTO.getPassword(), registroDTO.getUsuario_codigo());
		usuario.setDtype("COMITE");

		return usuarioRepositorio.save(usuario);
	}
	@Override
	public clsUsuario guardarConsejo(UsuarioRegistroDTO registroDTO) {
		System.out.printf("Codigo", registroDTO.getUsuario_codigo());
		clsConsejoFacultad usuario = new clsConsejoFacultad(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),registroDTO.getPassword(), registroDTO.getUsuario_codigo(),registroDTO.getDtype());
		usuario.setDtype("FACULTAD");
		return usuarioRepositorio.save(usuario);
	}
	
    @Override
    public Optional<clsUsuario> obtenerUsuario(Long userId) {
        return usuarioRepositorio.findById(userId);
    }
    @Override
    public Optional<clsUsuario> obtenerUsuario(String username) {
        return Optional.ofNullable(usuarioRepositorio.findByEmail(username));
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
    	usuarioRepositorio.deleteById(usuarioId);
    }
	
	@Override
	public List<clsUsuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}

	   @Override
	   @Transactional
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        clsUsuario usuario = this.usuarioRepositorio.findByEmail(username);
	        if(usuario == null){
	            throw new UsernameNotFoundException("Usuario no encontrado");
	        }
	        return (UserDetails) usuario;
	    }

	   @Override
	   @Transactional
	   public clsUsuario addProject(String username, String atrTitulo) {
	       Optional<clsUsuario> usuarioOptional = Optional.ofNullable(this.usuarioRepositorio.findByEmail(username));
	       if (usuarioOptional.isPresent()) {
	           clsUsuario usuario = usuarioOptional.get();
	           clsAnteproyecto anteproyecto = anteproyectoRepositorio.findByAtrTitulo(atrTitulo);

	           if (anteproyecto != null) {
	        	   System.out.println("atrTitulo: " + atrTitulo);
	        	    System.out.println("PasoFinalAQUI: " + anteproyecto.getAtrTitulo());
	        	    System.out.println("atrTitulo: " + atrTitulo);
	               usuario.agregarAnteproyecto(anteproyecto);
	               return usuarioRepositorio.save(usuario); // Guarda el usuario con el anteproyecto actualizado
	           }
	       }
	       return null; // Si no se encuentra el usuario o el anteproyecto, se devuelve null
	   }

	   @Override
	   @Transactional
	   public clsAnteproyecto agregarArchivo(Long usuarioId, String atrTitulo, MultipartFile archivoAdjunto) {
	       
		   try {
	           Optional<clsUsuario> usuarioOptional = this.usuarioRepositorio.findById(usuarioId);
	            System.out.println("El usuario si paso: " + usuarioId);
	            System.out.println("atrTitulo: " + atrTitulo);
	           if (usuarioOptional.isPresent()) {
	               clsUsuario usuario = usuarioOptional.get();
	               clsAnteproyecto anteproyecto = anteproyectoRepositorio.findByAtrTitulo(atrTitulo);
	               
	               if (anteproyecto != null && usuario.getAnteproyectos().contains(anteproyecto)) {
	                   if (archivoAdjunto != null && !archivoAdjunto.isEmpty()) {
	                	   System.out.println("El usuario si paso II: " + usuarioId);
	                       String fileName = StringUtils.cleanPath(archivoAdjunto.getOriginalFilename());

	                       String fileStoragePath = servletContext.getRealPath(fileUploadPath);

	                       System.out.println("La ruta es: " + fileStoragePath);
	                       System.out.println("La ruta es: " + fileUploadPath);


	                       File storageDirectory = new File(fileUploadPath);
	                       if (!storageDirectory.exists()) {
	                           storageDirectory.mkdirs();
	                       }

	                       // Crear una carpeta con el nombre del anteproyecto y el ID del usuario si no existe
	                       File anteproyectoDirectory = new File(storageDirectory, anteproyecto.getAtrTitulo());
	                       if (!anteproyectoDirectory.exists()) {
	                           anteproyectoDirectory.mkdirs();
	                       }
	                       System.out.println("Estamos viendo: " + usuarioId);
	       	            System.out.println("atrTitulo: " + atrTitulo);
	                       String filePath = Paths.get(anteproyectoDirectory.getAbsolutePath(), fileName).toString();
	                       Files.copy(archivoAdjunto.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
	                       System.out.println("Estamos viendo: " + usuario.getRol());
	                       System.out.println("Estamos viendo: " + anteproyecto.getAtrEstado());
	                       anteproyecto.setArchivoAdjunto(filePath);
	                       if("DIRECTOR".equals(usuario.getRol()) && anteproyecto.getAtrEstado() == null) {
	                    	   System.out.println("Estamos viendo: " + usuario.getRol());
	   	       	            System.out.println("atrTitulo: " + atrTitulo);
	   	       	      System.out.println("Estamos viendo: " + anteproyecto.getAtrEstado());
	                    	   clsUsuario Departamento = this.usuarioRepositorio.findByEmail("departamento@unicauca.edu.co");
	                    	   anteproyecto.setAtrEstado("formato A");
	                    	   Departamento.agregarAnteproyecto(anteproyecto);
	                    	   usuarioRepositorio.save(Departamento);
	                       }else if("DIRECTOR".equals(usuario.getRol()) && "resolucion".equals(anteproyecto.getAtrEstado())){
	                    	   anteproyecto.setAtrEstado("formato E");
	                       }else if("COMITE".equals(usuario.getRol()) && "formato A".equals(anteproyecto.getAtrEstado())){
	                    	   anteproyecto.setAtrEstado("aceptacion formato A");   
	                       }else if("JURADO".equals(usuario.getRol()) && "aceptacion formato A".equals(anteproyecto.getAtrEstado())){
	                    	   anteproyecto.setAtrEstado("formato B");
	                       }else if("JEFEDEPARTAMENTO".equals(usuario.getRol()) && "formato B".equals(anteproyecto.getAtrEstado())){
	                    	   anteproyecto.setAtrEstado("formato C");
	                       }else if("FACULTAD".equals(usuario.getRol()) && "formato C".equals(anteproyecto.getAtrEstado())){
	                    	   anteproyecto.setAtrEstado("resolucion");
	                       }
	                       return anteproyectoRepositorio.save(anteproyecto);
	                   } else {
	                       throw new RuntimeException("El archivo adjunto está vacío.");
	                   }
	               } else {
	                   throw new RuntimeException("El anteproyecto no se encontró o no está asociado al usuario.");
	               }
	           } else {
	               throw new RuntimeException("El usuario no se encontró.");
	           }
	       } catch (Exception e) {
	           e.printStackTrace();
	           return null;
	       }
	   }


	   
	   @Override
	public clsUsuario obtenerUsuarioNombre(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	   
	   
	   public clsAnteproyecto addCommentToAnteproyecto(String username, String atrTitulo, String comentario) {
	        // Buscar el anteproyecto por el título
	        clsAnteproyecto anteproyecto = anteproyectoRepositorio.findByAtrTitulo(atrTitulo);

	        if (anteproyecto == null) {
	            // Manejar el caso en que el anteproyecto no se encuentra
	            throw new ResourceNotFoundException("Anteproyecto no encontrado con el título: " + atrTitulo);
	        }

	        // Buscar el usuario por ID
	        clsUsuario usuario = usuarioRepositorio.findByEmail(username);
	        if (usuario == null) {
	            throw new ResourceNotFoundException("Usuario no encontrado con el EMAIL: " + username);
	        }
	        // Verificar si el usuario está asociado con el anteproyecto
	        if (!anteproyecto.getUsuarios().contains(usuario)) {
	            // Manejar el caso en que el usuario no está asociado con el anteproyecto
	            throw new ResourceNotFoundException("El usuario no está asociado con este anteproyecto");
	        }
	        
	        // Agregar el comentario al anteproyecto
	        anteproyecto.agregarComentario(comentario);

	        // Guardar el anteproyecto actualizado
	        return anteproyectoRepositorio.save(anteproyecto);
	    }
	   
	    // Método para descargar un archivo específico
	    public ResponseEntity<Resource> descargarArchivo(String tituloAnteproyecto, String nombreArchivo) {
	        try {
	            Path archivoPath = Paths.get(fileUploadPath).resolve(tituloAnteproyecto).resolve(nombreArchivo).normalize();
	            Resource recurso = new UrlResource(archivoPath.toUri());

	            if (recurso.exists() && recurso.isReadable()) {
	                return ResponseEntity.ok()
	                        .header("Content-Disposition", "attachment; filename=\"" + recurso.getFilename() + "\"")
	                        .body(recurso);
	            } else {
	                throw new RuntimeException("El archivo no se pudo encontrar o leer: " + nombreArchivo);
	            }
	        } catch (Exception e) {
	            throw new RuntimeException("Error al descargar el archivo: " + nombreArchivo, e);
	        }
	    }


	    @Transactional
	    public clsUsuario actualizarUsuario(String email, UsuarioRegistroDTO usuarioDTO, String rol) {
	    	System.out.println("El usuario si paso II: ");
	    	clsUsuario usuarioExistente = usuarioRepositorio.findByEmail(email);
	    	 if (usuarioExistente == null) {
		            throw new ResourceNotFoundException("Usuario no encontrado con el EMAIL: " + email);
		        }
	        // Actualizar los campos del usuario
	        usuarioExistente.setUsuario_nombres(usuarioDTO.getUsuario_nombres());
	        usuarioExistente.setUsuario_apellidos(usuarioDTO.getUsuario_apellidos());
	        usuarioExistente.setEmail(usuarioDTO.getEmail());
	        usuarioExistente.setUsuario_codigo(usuarioDTO.getUsuario_codigo());
	        usuarioExistente.setPassword(usuarioDTO.getPassword());
	        usuarioExistente.setRol(rol);	        
	        return usuarioRepositorio.save(usuarioExistente);
	    }

	
}
