package ar.nix.relevando.controllers;

import ar.nix.relevando.models.Peligro;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PeligroController {

	
	private List<Peligro> peligros = new ArrayList<>();

	public List<Peligro> getPeligros() {
		Peligro peligroModel = new Peligro();
		var peligrosData = peligroModel.findAll();
		this.peligros = peligrosData;
		return peligros;
    }

    public void crearPeligro(String titulo, String descripcion, String direccion,String barrio,String ciudad,String provincia,Integer responsableId,Integer categoriaId) {
        int nuevoId = peligros.size() + 1; 
        if(!validarEntrada( titulo, descripcion,direccion,barrio,ciudad,provincia,responsableId,categoriaId)) {
        	return;
        }
        Peligro nuevoPeligro = new Peligro(nuevoId, titulo, descripcion,direccion,barrio,ciudad,provincia,responsableId,categoriaId);
        nuevoPeligro.save();
        peligros.add(nuevoPeligro);
        System.out.println("Peligro creado: " + nuevoPeligro);
    }
    
    
    public void editarPeligro(int id, String titulo, String descripcion , String direccion,String barrio,String ciudad,String provincia,Integer responsableId,Integer categoriaId) {
        Optional<Peligro> peligroOptional = buscarPeligroPorId(id);
        if (peligroOptional.isPresent()) {
            Peligro peligro = peligroOptional.get();
            if(!validarEntrada( titulo, descripcion,direccion,barrio,ciudad,provincia,responsableId,categoriaId)) {
                return;
            }
            peligro.setTitulo(titulo);
            peligro.setDescripcion(descripcion);
            System.out.println("Peligro actualizado: " + peligro);
            peligro.save();
            return;
        }
        System.out.println("No se encontró el peligro con ID: " + id);
        return;
    }
    
    
    
   public boolean eliminarPeligro(int id) {
        Optional<Peligro> peligroAEliminar = buscarPeligroPorId(id);
        if (peligroAEliminar.isPresent()) {
        	
        	var peligro = peligroAEliminar.get();
        	peligro.deleteFromDb();
            peligros.remove(peligro);
            System.out.println("Peligro eliminado con ID: " + id);
            return true;
        }
        System.out.println("No se encontró el peligro con ID: " + id);
        return false;
    }
  
    public Optional<Peligro> buscarPeligroPorId(int id) {
       Peligro model = new Peligro();
 	   var data = model.findOne(id);
 	   return Optional.of(data);
    }
	
    public void mostrarPeligro(int id) {
    	var peligro = buscarPeligroPorId(id);
        if (peligro.get().getId() > 0) {
            System.out.println(peligro);
        } else {
            System.out.println("Peligro no encontrado");	
        }
    }
    
    public void mostrarPeligros() {
    	this.getPeligros();
        if (peligros.isEmpty()) {
            System.out.println("No hay peligros registrados.");
        } else {
            for (Peligro peligro : peligros) {
                System.out.println(peligro);
            }
        }
    }
    
    

	public boolean validarEntrada(String titulo, String descripcion, String direccion,String barrio,String ciudad,String provincia,Integer responsableId,Integer categoriaId) {
	    if (titulo == null || titulo.trim().isEmpty()) {
	        System.out.println("Error: El título no puede estar vacío.");
	        return false;
	    }
	    
	    if (descripcion == null || descripcion.trim().isEmpty()) {
	        System.out.println("Error: La descripción no puede estar vacía.");
	        return false;
	    }
	    
	    if (direccion == null || direccion.trim().isEmpty()) {
	        System.out.println("Error: La dirección no puede estar vacía.");
	        return false;
	    }
	    
	    if (barrio == null || barrio.trim().isEmpty()) {
	        System.out.println("Error: El barrio no puede estar vacío.");
	        return false;
	    }
	    
	    if (ciudad == null || ciudad.trim().isEmpty()) {
	        System.out.println("Error: La ciudad no puede estar vacía.");
	        return false;
	    }
	    
	    if (provincia == null || provincia.trim().isEmpty()) {
	        System.out.println("Error: La provincia no puede estar vacía.");
	        return false;
	    }
	    
	    if (responsableId == null || responsableId <= 0) {
	        System.out.println("Error: El ID del responsable debe ser un número positivo.");
	        return false;
	    }
	    
	    if (categoriaId == null || categoriaId <= 0) {
	        System.out.println("Error: El ID de la categoría debe ser un número positivo.");
	        return false;
	    }


        return true;
	}
		
}
