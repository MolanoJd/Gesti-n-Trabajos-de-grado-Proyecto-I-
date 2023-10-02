package com.gestionTrabajos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gestionTrabajos.modelo.clsAnteproyecto;
import com.gestionTrabajos.repository.AnteproyectoRepository;

@Controller
public class DirectorController {


	@Autowired
	private AnteproyectoRepository anteproyectoRepository;

	

    @PostMapping("/director/agregarComentarios")
    @ResponseBody
    public Boolean agregarComentarios(@RequestParam String comentario, @RequestParam Integer anteproyectoId) {
        clsAnteproyecto anteproyecto = anteproyectoRepository.findById(anteproyectoId).orElse(null);
        if (anteproyecto != null) {
            anteproyecto.agregarComentario(comentario);
            anteproyectoRepository.save(anteproyecto);
            return true;
        }
        return false;
    }
    
    
    @PostMapping("/director/crearAsesoria")
    @ResponseBody
    public Boolean crearAsesoria(@RequestParam Integer anteproyectoId) {
        // Aquí puedes implementar la lógica para crear una asesoría para el anteproyecto.
        // Por ejemplo, crear una nueva asesoría y asociarla con el anteproyecto.

        // directorService.crearAsesoria(anteproyectoId);

        return true; // Este es un valor ficticio. Debes reemplazarlo con la lógica adecuada.
    }
}
