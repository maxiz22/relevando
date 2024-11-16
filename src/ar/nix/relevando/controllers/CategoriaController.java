package ar.nix.relevando.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.nix.relevando.models.Categoria;

public class CategoriaController {

	private List<Categoria> categorias = new ArrayList<>();

	public List<Categoria> getCategorias() {	
		Categoria cat = new Categoria();
		var catData = cat.findAll();
		this.categorias = catData;
		return categorias;
	}

	public boolean validarEntrada(String titulo,String descripcion) {
       if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("Error: El título no puede estar vacío.");
            return false;
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            System.out.println("Error: La descripción no puede estar vacía.");
            return false;
        }
        return true;
	}
	
	
	public void crearCategoria(String titulo, String descripcion) {
	    if(!validarEntrada(titulo,descripcion)) {
	    	return;
	    }
	    Categoria nuevaCategoria = new Categoria(null, titulo, descripcion);
	    nuevaCategoria.save();
	    categorias.add(nuevaCategoria);
	    System.out.println("Categoria creada: " + nuevaCategoria);
    }
	    
	public boolean eliminarCategoria(int id) {
	    Optional<Categoria> categoria = buscarCategoriaPorId(id);
	    if (categoria.isPresent()) {
	    	var cat = categoria.get();
	    	cat.deleteFromDb(cat.getId());
            categorias.remove(cat);
            System.out.println("Categoria eliminada con ID: " + id);
	        return true;
	    }
	    System.out.println("No se encontró la Categoria con ID: " + id);
	    return false;
	}
	  
	public Optional<Categoria> buscarCategoriaPorId(int id) {
		Categoria cat = new Categoria();
		var catData = cat.findOne(id);
		return Optional.of(catData);
	}
		
	public void mostrarCategorias() {
		this.getCategorias();
	    if (categorias.isEmpty()) {
	        System.out.println("No hay categorias registrados.");
	    } else {
	        for (Categoria categoria : categorias) {
	            System.out.println(categoria);
	        }
	    }
	}
}
