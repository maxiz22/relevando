package ar.nix.relevando.views;

import ar.nix.relevando.Relevando;
import ar.nix.relevando.controllers.PeligroController;
import ar.nix.relevando.controllers.TramiteController;
import ar.nix.relevando.enums.EstadoTramite;
import ar.nix.relevando.exceptions.PeligroNotFoundException;

public class PeligroSingleView extends Menu {


    private PeligroController peligroController;
    private TramiteController tramiteController;
    private Integer peligroId;
    private Relevando relevandoApp;
    
    public PeligroSingleView(Relevando relevandoApp,Integer peligroId) {
        this.peligroController = relevandoApp.getPeligroController();
        this.peligroId = peligroId;
        this.tramiteController = relevandoApp.getTramiteController();
        this.relevandoApp = relevandoApp;
        
    }
    
    
	@Override
    protected void mostrarOpciones() {
	      peligroController.mostrarPeligro(this.peligroId);
        System.out.println("----- Menú de Peligro ID "+this.peligroId+" -----");
        System.out.println("1. Nuevo Trámite");
        System.out.println("2. Listar Trámites");
        System.out.println("3. Volver al Menú Principal");
    }

    @Override
    protected void procesarOpcion(int opcion) {
    	 int id;
    	 
        switch (opcion) {
            case 1:
             	int peligroId = this.peligroId;
             	int estadoOption;
             	int estado;
                while (true) {
                    System.out.println("Ingrese el estado (1 para NOTIFICAR, 2 para SOLUCIÓN): ");
                    estadoOption = scanner.nextInt();
                    if (estadoOption == 1) {
                        estado = EstadoTramite.PENDIENTE.getCodigo();
                        break;
                    } else if (estadoOption == 2) {
                        estado = EstadoTramite.SOLUCIONADO.getCodigo();
                        break;
                    } else {
                        System.out.println("Opción Inválida. Por favor, ingrese 1 o 2.");
                    }
                }
                this.relevandoApp.getResponsableController().mostrarResponsables();
             	System.out.println("Ingrese el responsable:");
             	int responsableId = scanner.nextInt();
             	
             	scanner.nextLine();
               	System.out.println("Ingrese comentarios:");
             	String descripcion = scanner.nextLine();
             	
				try {
					tramiteController.crearTramite(peligroId, responsableId,estado,descripcion);
				} catch (PeligroNotFoundException e) {
			           System.out.println("Peligro inválido.");
				}
                break;
            case 2:
            	tramiteController.mostrarTramitesByPeligroId(this.peligroId);
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    @Override
    protected boolean esOpcionSalir(int opcion) {
        return opcion ==3; 
    }
}
