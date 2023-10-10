package com.gestionTrabajos.Anteproyecto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnteproyectoController {

	@Autowired
	private AnteproyectoRepository anteproyectoRepository;
	
	@GetMapping("/anteproyecto")
	public String listarAnteproyecto(Model modelo) {
		List<clsAnteproyecto> listaAnteproyectos = anteproyectoRepository.findAll();
		modelo.addAttribute("listaAnteproyectos", listaAnteproyectos);
		return "anteproyectos";
	}

	@GetMapping("/anteproyecto/nuevo")
	public String mostrarFormularioDeNuevoAnteproyecto(Model modelo) {
		modelo.addAttribute("anteproyecto", new clsAnteproyecto());
		return "anteproyecto_formulario";
	}
	
	@PostMapping("/anteproyecto/guardar")
	public String guardarAnteproyecto(clsAnteproyecto anteproyecto) {
		anteproyectoRepository.save(anteproyecto);
		return "redirect:/anteproyectos";
	}
	
	@GetMapping("/anteproyecto/editar/{id}")
	public String mostrarFormularioDeModificarProducto(@PathVariable("id") Integer  id,Model modelo) {
		clsAnteproyecto categoria = anteproyectoRepository.findById(id).get();
		modelo.addAttribute("categoria", categoria);
		
		return "anteproyecto_formulario";
	}
	
	@GetMapping("/categorias/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") Integer id,Model modelo) {
		anteproyectoRepository.deleteById(id);
		return "redirect:/anteproyecto";
	}
}
