package ar.nix.relevando.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.nix.relevando.models.Categoria;
import ar.nix.relevando.models.Responsable;

public class ResponsableController {

	private List<Responsable> responsables = new ArrayList<>();

	public List<Responsable> getResponsables() {
		Responsable responsable = new Responsable();
		var responsableData = responsable.findAll();
		this.responsables = responsableData;
		return responsables;
    }
	

	public boolean validarEntrada(String nombre,String email,String telefono) {
	   if (nombre == null || nombre.trim().isEmpty()) {
	        System.out.println("Error: El nombre no puede estar vacío.");
	        return false;
	    }
	    
	    if (email == null || email.trim().isEmpty()) {
	        System.out.println("Error: El email no puede estar vacío.");
	        return false;
	    }
	    
	    if (telefono == null || telefono.trim().isEmpty()) {
	        System.out.println("Error: El teléfono no puede estar vacío.");
	        return false;
	    }
        return true;
	}
	
	
    public void crearResponsable(String nombre, String email, String telefono) {
    	if(!validarEntrada(nombre,email,telefono)) {
    		return;
    	}
        int nuevoId = responsables.size() + 1; 
        Responsable responsable = new Responsable(nuevoId, nombre, email,telefono);
        responsable.save();
        responsables.add(responsable);
        System.out.println("Responsable creado: " + responsable);
    }
    
   public boolean eliminarResponsable(int id) {
        Optional<Responsable> responsable = buscarResponsablePorId(id);
        if (responsable.isPresent()) {
        	var resp = responsable.get();
        	resp.deleteFromDb(resp.getId());
        	responsables.remove(resp);
            System.out.println("Responsable eliminado con ID: " + id);
            return true;
        }
        System.out.println("No se encontró el responsable con ID: " + id);
        return false;
    }
  
    public Optional<Responsable> buscarResponsablePorId(int id) {
		Responsable resp = new Responsable();
		var respData = resp.findOne(id);
		return Optional.of(respData);
    }
	
    public void mostrarResponsables() {
    	this.getResponsables();
        if (responsables.isEmpty()) {
            System.out.println("No hay peligros registrados.");
        } else {
            for (Responsable responsable : responsables) {
                System.out.println(responsable);
            }
        }
    }
}
