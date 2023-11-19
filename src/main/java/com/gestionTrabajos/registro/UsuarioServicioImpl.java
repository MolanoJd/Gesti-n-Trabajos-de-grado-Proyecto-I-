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


import com.gestionTrabajos.Anteproyecto.AnteproyectoRepository;
import com.gestionTrabajos.Anteproyecto.clsAnteproyecto;
import com.gestionTrabajos.modelo.clsEstudiante;



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
	
	@Override
	public clsUsuario guardarEstudiante(UsuarioRegistroDTO registroDTO) {
		clsEstudiante usuario = new clsEstudiante(registroDTO.getUsuario_nombres(), 
				registroDTO.getUsuario_apellidos(),registroDTO.getEmail(),registroDTO.getPassword());
		return usuarioRepositorio.save(usuario);

	}

    
    @Override
    public Optional<clsUsuario> obtenerUsuario(Long userId) {
        return usuarioRepositorio.findById(userId);
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

	/*   @Override
	   @Transactional
	   public void addProject(Long usuarioId, String atrTitulo) throws NotFoundException {
		 System.out.println("userId: " + usuarioId);
		 System.out.println("atrTitulo: " + atrTitulo);

	       Optional<clsUsuario> usuarioOptional = this.usuarioRepositorio.findById(usuarioId);
	       System.out.println("Paso: " + usuarioOptional.get().email);
	       System.out.println("Paso: " + usuarioOptional.get().usuario_nombres);
	       System.out.println("Paso: " +usuarioOptional.get().usuario_codigo);
	       if (usuarioOptional.get().getDocente_nombres() != null) {
	           clsUsuario usuario = usuarioOptional.get();
	           System.out.println("Paso: " +usuarioOptional.get().usuario_codigo);
	           System.out.println("atrTituloAQUI: " + atrTitulo);
	           //clsAnteproyecto anteproyectoOptional = anteproyectoRepositorio.findByAtrTitulo("Aplicación de automatas celulares");
	           List<clsAnteproyecto>anteproyectosOptional = anteproyectoRepositorio.findAll();
	           System.out.println("Tamaño: " + anteproyectosOptional.size());
	           for (clsAnteproyecto anteproyecto : anteproyectosOptional) {
	               if (anteproyecto.getAtrTitulo() != null && anteproyecto.getAtrTitulo().equals(atrTitulo)) {
	            	   
	    	           System.out.println("atrTitulo: " + atrTitulo);
	    	           System.out.println("PasoFinal: " + anteproyecto.getAtrTitulo());
	    	           System.out.println("atrTitulo: " + atrTitulo);
	    	           usuario.agregarAnteproyecto(anteproyecto);
		               usuarioRepositorio.save(usuario);
	               }
	           }
	          
	               
	             
	          
	       } else {
	           throw new NotFoundException();
	       }
	   }
*/
/*	   @Override
	   @Transactional
	   public clsUsuario addProject(Long usuarioId, String atrTitulo){
		 System.out.println("userId: " + usuarioId);
		 System.out.println("atrTitulo: " + atrTitulo);

	       Optional<clsUsuario> usuarioOptional = this.usuarioRepositorio.findById(usuarioId);
	       System.out.println("Paso: " + usuarioOptional.get().email);
	       System.out.println("Paso: " + usuarioOptional.get().usuario_nombres);
	       System.out.println("Paso: " +usuarioOptional.get().usuario_codigo);
	       if (usuarioOptional.get().getDocente_nombres() != null) {
	           clsEstudiante usuario = (clsEstudiante) usuarioOptional.get();
	           System.out.println("Paso: " +usuarioOptional.get().usuario_codigo);
	           System.out.println("atrTituloAQUI: " + atrTitulo);
	           clsAnteproyecto anteproyectoOptional = anteproyectoRepositorio.findByAtrTitulo(atrTitulo);
	           List<clsAnteproyecto>anteproyectosOptional = anteproyectoRepositorio.findAll();
	           
	           if (anteproyectoOptional != null && anteproyectoOptional.getAtrTitulo() != null && anteproyectoOptional.getAtrTitulo().equals(atrTitulo)) {
	        	    System.out.println("atrTitulo: " + atrTitulo);
	        	    System.out.println("PasoFinal: " + anteproyectoOptional.getAtrTitulo());
	        	    System.out.println("atrTitulo: " + atrTitulo);
	        	    usuario.agregarAnteproyecto(anteproyectoOptional);
	        	    return usuarioRepositorio.save(usuario);
	        	}

	           
	          
	               
	             
	       }
		return null;
	   }
	   */
	   //C:\Users\juanM\AppData\Local\Temp\tomcat-docbase.8080.11721666356949382804\SubirArchivos
	   @Override
	   @Transactional
	   public clsUsuario addProject(Long usuarioId, String atrTitulo) {
	       Optional<clsUsuario> usuarioOptional = this.usuarioRepositorio.findById(usuarioId);
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
	                       
	                       if (fileStoragePath == null) {
	                           // Si fileUploadPath no está configurado correctamente en el archivo de propiedades, manejar el error
	                           throw new RuntimeException("La propiedad file.upload.path no está configurada correctamente.");
	                       }

	                       File storageDirectory = new File(fileStoragePath);
	                       if (!storageDirectory.exists()) {
	                           storageDirectory.mkdirs();
	                       }

	                       // Crear una carpeta con el nombre del anteproyecto y el ID del usuario si no existe
	                       File anteproyectoDirectory = new File(storageDirectory, anteproyecto.getAtrTitulo() + "_" + usuario.getId());
	                       if (!anteproyectoDirectory.exists()) {
	                           anteproyectoDirectory.mkdirs();
	                       }

	                       String filePath = Paths.get(anteproyectoDirectory.getAbsolutePath(), fileName).toString();
	                       Files.copy(archivoAdjunto.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

	                       anteproyecto.setArchivoAdjunto(filePath);

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

	 /*  
	   @Override
	   public void addProject(Long userId, clsAnteproyecto anteproyecto) throws NotFoundException {
	        Optional<clsUsuario> usuarioOptional = usuarioRepositorio.findById(userId);
	        if (usuarioOptional.isPresent()) {
	            clsUsuario usuario = usuarioOptional.get();
	            usuario.agregarAnteproyecto(anteproyecto); // Agregar el anteproyecto al usuario
	            usuarioRepositorio.save(usuario);
	        } else {
	            throw new NotFoundException(); // Manejar la excepción de usuario no encontrado
	        }
	    }
	@Override
	public clsUsuario obtenerUsuarioNombre(String username) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	
}
