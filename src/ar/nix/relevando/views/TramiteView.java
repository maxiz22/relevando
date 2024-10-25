package ar.nix.relevando.views;

import ar.nix.relevando.controllers.TramiteController;

public class TramiteView  extends Menu {
	
    private TramiteController tramiteController;
    private Integer peligroId;
    
    public TramiteView(TramiteController tramiteController, Integer peligroId) {
        this.tramiteController = tramiteController;
    }
    
    
    
	 @Override
	    protected void mostrarOpciones() {
	        System.out.println("----- Menú de Trámites -----");
	        System.out.println("1. Agregar Trámites");
	        System.out.println("2. Listar Trámites");
	        System.out.println("3. Eliminar Trámites");
	        System.out.println("4. Volver al Menú Principal");
	    }

	    @Override
	    protected void procesarOpcion(int opcion) {
	        switch (opcion) {
	            case 1:
	            	scanner.nextLine();
	             	System.out.println("Ingrese el responsable:");
	             	int responsableId = scanner.nextInt();
	              
	                tramiteController.crearTramite(this.peligroId, responsableId);
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
