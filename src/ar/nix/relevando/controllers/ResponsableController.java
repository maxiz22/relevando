package ar.nix.relevando.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.nix.relevando.models.Peligro;
import ar.nix.relevando.models.Responsable;

public class ResponsableController {

	private List<Responsable> responsables = new ArrayList<>();

	public List<Responsable> getResponsables() {
        return responsables;
    }
	

	
    public void crearResponsable(String nombre, String email, String telefono) {
        int nuevoId = responsables.size() + 1; 
        Responsable responsable = new Responsable(nuevoId, nombre, email,telefono);
        responsables.add(responsable);
        System.out.println("Responsable creado: " + responsable);
    }
    
   public boolean eliminarResponsable(int id) {
        Optional<Responsable> responsable = buscarResponsablePorId(id);
        if (responsable.isPresent()) {
        	responsables.remove(responsable.get());
            System.out.println("Responsable eliminado con ID: " + id);
            return true;
        }
        System.out.println("No se encontró el responsable con ID: " + id);
        return false;
    }
  
    public Optional<Responsable> buscarResponsablePorId(int id) {
        return responsables.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }
	
    public void mostrarResponsables() {
        if (responsables.isEmpty()) {
            System.out.println("No hay peligros registrados.");
        } else {
            for (Responsable responsable : responsables) {
                System.out.println(responsable);
            }
        }
    }
}
