package ar.nix.relevando.views;

import ar.nix.relevando.controllers.PeligroController;

public class PeligroView extends Menu {


    private PeligroController peligroController;

    public PeligroView(PeligroController peligroController) {
        this.peligroController = peligroController;
    }
    
    
	@Override
    protected void mostrarOpciones() {
        System.out.println("----- Menú de Peligros -----");
        System.out.println("1. Agregar Peligro");
        System.out.println("2. Listar Peligros");
        System.out.println("3. Eliminar Peligro");
        System.out.println("4. Volver al Menú Principal");
    }

    @Override
    protected void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
            	scanner.nextLine();
            	System.out.println("Ingrese el título de la categoría:");
                String titulo = scanner.nextLine();
                System.out.println("Ingrese la descripción de la categoría:");
                String descripcion = scanner.nextLine();
                peligroController.crearPeligro(titulo, descripcion);
                
                break;
            case 2:
            	peligroController.mostrarPeligros();
                break;
            case 3:
                System.out.println("Ingrese el ID de la categoría a eliminar:");
                int id = scanner.nextInt();
                peligroController.eliminarPeligro(id);
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
