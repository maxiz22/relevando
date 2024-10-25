package ar.nix.relevando.controllers;

import ar.nix.relevando.models.Responsable;
import ar.nix.relevando.models.Tramite;
import ar.nix.relevando.enums.EstadoTramite;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TramiteController {
	
    private List<Tramite> tramites = new ArrayList<>();
	
    
	
    public void crearTramite(Integer peligroId, Integer responsableId) {
        int nuevoId = tramites.size() + 1; 
        Tramite tramite = new Tramite(nuevoId, peligroId, responsableId);
        tramites.add(tramite);
        System.out.println("Trámite creado: " + tramite);
    }
    
   public boolean eliminarTramite(int id) {
        Optional<Tramite> tramite = buscarTramitePorId(id);
        if (tramite.isPresent()) {
        	tramites.remove(tramite.get());
            System.out.println("Responsable eliminado con ID: " + id);
            return true;
        }
        System.out.println("No se encontró el responsable con ID: " + id);
        return false;
    }
  
   public Optional<Tramite> buscarTramitePorId(int id) {
       return tramites.stream()
               .filter(p -> p.getId() == id)
               .findFirst();
   }
    public void mostrarTramites() {
        if (tramites.isEmpty()) {
            System.out.println("No hay peligros registrados.");
        } else {
            for (Tramite tramite : tramites) {
                System.out.println(tramite);
            }
        }
    }

}
