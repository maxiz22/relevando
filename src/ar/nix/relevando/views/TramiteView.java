package ar.nix.relevando.views;

import ar.nix.relevando.controllers.TramiteController;
import ar.nix.relevando.enums.EstadoTramite;
import ar.nix.relevando.exceptions.PeligroNotFoundException;

public class TramiteView  extends Menu {
	
    private TramiteController tramiteController;
    private Integer peligroId;
    
    public TramiteView(TramiteController tramiteController) {
        this.tramiteController = tramiteController;
    }
    
    
    
	 @Override
	    protected void mostrarOpciones() {
	        System.out.println("----- Menú de Trámites -----");
	        System.out.println("1. Nuevo Trámite");
	        System.out.println("2. Listar Trámites");
	        System.out.println("3. Eliminar Trámites");
	        System.out.println("4. Volver al Menú Principal");
	    }

	    @Override
	    protected void procesarOpcion(int opcion) {
	        switch (opcion) {
	            case 1:
	            	scanner.nextLine();
	             	System.out.println("Ingrese el ID peligro:");
	             	int peligroId = scanner.nextInt();
	             	System.out.println("Ingrese el responsable:");
	             	int responsableId = scanner.nextInt();
	               	System.out.println("Ingrese descripción:");
	             	String descripcion = scanner.nextLine();
	             	
	             	int estadoOption;
	             	int estado;
	             	
	             	
	                while (true) {
	                    System.out.println("Ingrese el estado (1 para NOTIFICAR, 2 para SOLUCIONADO): ");
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
	                
	                
					try {
						tramiteController.crearTramite(peligroId, responsableId,estado,descripcion);
					} catch (PeligroNotFoundException e) {
				           System.out.println("Peligro inválido.");
					}
	                break;
	            case 2:
	 
	            	tramiteController.mostrarTramites();
	                break;
	            case 3:
	                System.out.println("Ingrese el ID del trámite a eliminar:");
	                int id = scanner.nextInt();
	                tramiteController.eliminarTramite(id);
	                break;
	            case 4:
	                System.out.println("Volviendo al Menú Principal...");
	                break;
	            default:
	                System.out.println("Opción inválida.");
	        }
	    }

	    @Override
	    protected boolean esOpcionSalir(int opcion) {
	        return opcion == 4;  // Volver al menú principal
	    }
}
