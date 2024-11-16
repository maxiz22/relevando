package ar.nix.relevando.controllers;

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
	
	public List<Tramite> getTramites() {
		Tramite tramiteModel = new Tramite();
		var tramiteData = tramiteModel.findAll();
		this.tramites = tramiteData;
		return tramites;
    }
	
	
    public void crearTramite(Integer peligroId, Integer responsableId, Integer estado,String descripcion) throws PeligroNotFoundException {
     
    	Peligro peligro;
        
        Optional<Peligro> peligroOptional = relevandoApp.getPeligroController().buscarPeligroPorId(peligroId);
        if (peligroOptional.isPresent()) {
        	peligro = peligroOptional.get();
        }else {
            throw new PeligroNotFoundException("El peligro con ID " + peligroId + " no existe.");
        }
     
        Tramite tramite = new Tramite(null, peligroId, responsableId,estado,descripcion);
        tramite.save();
        tramites.add(tramite);
        System.out.println("Trámite creado: " + tramite);
   
        if(estado == EstadoTramite.PENDIENTE.getCodigo()) {
            System.out.println("Se ha ejecutado el envío de la notificación del trámite " + tramite.getId());
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
        	
        	var tram = tramite.get();
        	tram.deleteFromDb(tram.getId());
        	
        	tramites.remove(tram);
            System.out.println("Responsable eliminado con ID: " + id);
            return true;
        }
        System.out.println("No se encontró el responsable con ID: " + id);
        return false;
    }
  
   public Optional<Tramite> buscarTramitePorId(int id) {
	   Tramite model = new Tramite();
	   var data = model.findOne(id);
	   return Optional.of(data);
   }
   
    public void mostrarTramites() {
    	this.getTramites();
        if (tramites.isEmpty()) {
            System.out.println("No hay peligros registrados.");
        } else {
            for (Tramite tramite : tramites) {
                System.out.println(tramite);
            }
        }
    }
    
    public void mostrarTramitesByPeligroId(Integer peligroId) {
    	this.getTramites();
    	Boolean print = false;
        for (Tramite tramite : tramites) {
        	if(tramite.getPeligroId() == peligroId) {
                System.out.println(tramite);
                print = true;
        	}
    
        }
        if(!print) {
        	   System.out.println("No se han encontrado trámites");
        }
    	
    }

}
