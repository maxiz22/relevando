package ar.nix.relevando.controllers;

import ar.nix.relevando.models.Responsable;
import ar.nix.relevando.models.Tramite;
import ar.nix.relevando.models.Peligro;
import ar.nix.relevando.Relevando;
import ar.nix.relevando.enums.EstadoPeligro;
import ar.nix.relevando.enums.EstadoTramite;
import ar.nix.relevando.exceptions.PeligroNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TramiteController {
	
    private List<Tramite> tramites = new ArrayList<>();
	
    
	private Relevando relevandoApp;
	
	public TramiteController(Relevando relevandoApp) {
		this.relevandoApp = relevandoApp;
	}
	
	
	
    public void crearTramite(Integer peligroId, Integer responsableId, Integer estado,String descripcion) throws PeligroNotFoundException {
        int nuevoId = tramites.size() + 1; 
    	Peligro peligro;
        
        Optional<Peligro> peligroOptional = relevandoApp.getPeligroController().buscarPeligroPorId(peligroId);
        if (peligroOptional.isPresent()) {
        	peligro = peligroOptional.get();
        }else {
        	
            throw new PeligroNotFoundException("El peligro con ID " + peligroId + " no existe.");

        }
     
        Tramite tramite = new Tramite(nuevoId, peligroId, responsableId,estado,descripcion);
        tramites.add(tramite);
        System.out.println("Trámite creado: " + tramite);
   
        
        
        if(estado == EstadoTramite.PENDIENTE.getCodigo()) {
        	
            System.out.println("Se ha ejecutado el envío de la notificación del trámite " + nuevoId);
            
            tramite.setEstado(EstadoTramite.EJECUTADO.getCodigo());
         	 peligro.setEstado(EstadoPeligro.TRAMITADO.getCodigo());
        }else if(estado == EstadoTramite.SOLUCIONADO.getCodigo()) {
        	
        	 peligro.setEstado(EstadoPeligro.SOLUCIONADO.getCodigo());
        }
    }
    
    public void editarTramite(int id, Integer peligroId, Integer responsableId, Integer estado, String descripcion) throws PeligroNotFoundException {
        Optional<Tramite> tramiteOptional = buscarTramitePorId(id);
        if (tramiteOptional.isPresent()) {
            Tramite tramite = tramiteOptional.get();
            tramite.setPeligroId(peligroId);
            tramite.setResponsableId(responsableId);
            tramite.setEstado(estado);
            tramite.setDescripcion(descripcion);
            
            Optional<Peligro> peligroOptional = relevandoApp.getPeligroController().buscarPeligroPorId(peligroId);
            if (peligroOptional.isEmpty()) {
                throw new PeligroNotFoundException("El peligro con ID " + peligroId + " no existe.");
            }
            
            if (estado == EstadoTramite.SOLUCIONADO.getCodigo()) {
                peligroOptional.get().setEstado(EstadoPeligro.SOLUCIONADO.getCodigo());
            }
            
            System.out.println("Trámite actualizado: " + tramite);
            return;
        }
        System.out.println("No se encontró el trámite con ID: " + id);
        return;
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
