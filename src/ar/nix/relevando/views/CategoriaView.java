package ar.nix.relevando.views;

import ar.nix.relevando.controllers.CategoriaController;


public class CategoriaView extends Menu {


    private CategoriaController categoriaController;

    public CategoriaView(CategoriaController categoriaController) {
        this.categoriaController = categoriaController;
    }
    
    
	@Override
    protected void mostrarOpciones() {
        System.out.println("----- Menú de Categorías -----");
        System.out.println("1. Agregar Categoría");
        System.out.println("2. Listar Categorías");
        System.out.println("3. Eliminar Categoría");
        System.out.println("4. Volver al Menú Principal");
    }

    @Override
    protected void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
            	System.out.println("Ingrese el título de la categoría:");
                String titulo = scanner.nextLine();
                System.out.println("Ingrese la descripción de la categoría:");
                String descripcion = scanner.nextLine();
                categoriaController.crearCategoria(titulo, descripcion);
                
                break;
            case 2:
            	  categoriaController.mostrarCategorias();
                break;
            case 3:
                System.out.println("Ingrese el ID de la categoría a eliminar:");
                int id = scanner.nextInt();
                categoriaController.eliminarCategoria(id);
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
