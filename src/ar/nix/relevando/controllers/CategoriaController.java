package ar.nix.relevando.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.nix.relevando.models.Categoria;

public class CategoriaController {

	
	private List<Categoria> categorias = new ArrayList<>();

	public List<Categoria> getCategorias() {
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
	    int nuevoId = categorias.size() + 1; 
	    
	    if(!validarEntrada(titulo,descripcion)) {
	    	return;
	    }
	    Categoria nuevaCategoria = new Categoria(nuevoId, titulo, descripcion);
	    categorias.add(nuevaCategoria);
	    System.out.println("Peligro creado: " + nuevaCategoria);
    }
	    
	public boolean eliminarCategoria(int id) {
	    Optional<Categoria> categoria = buscarCategoriaPorId(id);
	    if (categoria.isPresent()) {
            categorias.remove(categoria.get());
            System.out.println("Peligro eliminado con ID: " + id);
	        return true;
	    }
	    System.out.println("No se encontró el peligro con ID: " + id);
	    return false;
	}
	  
	public Optional<Categoria> buscarCategoriaPorId(int id) {
	    return categorias.stream()
	            .filter(p -> p.getId() == id)
	            .findFirst();
	}
		
	public void mostrarCategorias() {
	    if (categorias.isEmpty()) {
	        System.out.println("No hay categorias registrados.");
	    } else {
	        for (Categoria categoria : categorias) {
	            System.out.println(categoria);
	        }
	    }
	}
}
