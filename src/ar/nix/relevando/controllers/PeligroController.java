package ar.nix.relevando.controllers;

import ar.nix.relevando.models.Peligro;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PeligroController {

	
	private List<Peligro> peligros = new ArrayList<>();

	public List<Peligro> getPeligros() {
        return peligros;
    }

	
    public void crearPeligro(String titulo, String descripcion) {
        int nuevoId = peligros.size() + 1; 
        Peligro nuevoPeligro = new Peligro(nuevoId, titulo, descripcion);
        peligros.add(nuevoPeligro);
        System.out.println("Peligro creado: " + nuevoPeligro);
    }
    
   public boolean eliminarPeligro(int id) {
        Optional<Peligro> peligroAEliminar = buscarPeligroPorId(id);
        if (peligroAEliminar.isPresent()) {
            peligros.remove(peligroAEliminar.get());
            System.out.println("Peligro eliminado con ID: " + id);
            return true;
        }
        System.out.println("No se encontró el peligro con ID: " + id);
        return false;
    }
  
    public Optional<Peligro> buscarPeligroPorId(int id) {
        return peligros.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }
	
    public void mostrarPeligros() {
        if (peligros.isEmpty()) {
            System.out.println("No hay peligros registrados.");
        } else {
            for (Peligro peligro : peligros) {
                System.out.println(peligro);
            }
        }
    }
}
