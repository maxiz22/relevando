package ar.nix.relevando.views;

import ar.nix.relevando.controllers.ResponsableController;

public class ResponsableView extends Menu{

    private ResponsableController responsableController;

    public ResponsableView(ResponsableController responsableController) {
        this.responsableController = responsableController;
    }
    
	 @Override
	    protected void mostrarOpciones() {
	        System.out.println("----- Menú de Responsables -----");
	        System.out.println("1. Agregar Responsable");
	        System.out.println("2. Listar Responsables");
	        System.out.println("3. Eliminar Responsable");
	        System.out.println("4. Volver al Menú Principal");
	    }

	    @Override
	    protected void procesarOpcion(int opcion) {
	        switch (opcion) {
	            case 1:
	              	System.out.println("Ingrese el nombre:");
	                String nombre = scanner.nextLine();
	                System.out.println("Ingrese email:");
	                String email = scanner.nextLine();
	                System.out.println("Ingrese telefono:");
	                String telefono = scanner.nextLine();
	                responsableController.crearResponsable(nombre, email,telefono);
	                break;
	            case 2:
	            	responsableController.mostrarResponsables();
	                break;
	            case 3:
	                System.out.println("Ingrese el ID de la categoría a eliminar:");
	                int id = scanner.nextInt();
	                responsableController.eliminarResponsable(id);
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
	        return opcion == 4;
	    }
}
