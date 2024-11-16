package ar.nix.relevando.views;

import ar.nix.relevando.Relevando;
import ar.nix.relevando.controllers.PeligroController;

public class PeligroView extends Menu {


    private PeligroController peligroController;
    private Relevando relevandoApp;
    
    public PeligroView(PeligroController peligroController,Relevando relevandoApp) {
        this.peligroController = peligroController;
        this.relevandoApp = relevandoApp;
    }
    
    
	@Override
    protected void mostrarOpciones() {
        System.out.println("----- Menú de Peligros -----");
        System.out.println("1. Agregar Peligro");
        System.out.println("2. Listar Peligros");
        System.out.println("3. Ver Peligro");
        System.out.println("4. Modificar Peligro");
        System.out.println("5. Eliminar Peligro");
        System.out.println("6. Volver al Menú Principal");
    }

    @Override
    protected void procesarOpcion(int opcion) {
    	 int id;
    	 
        switch (opcion) {
            case 1:
            	scanner.nextLine();
            	System.out.println("Ingrese el título del peligro:");
                String titulo = scanner.nextLine();
                System.out.println("Ingrese la descripción del peligro:");
                String descripcion = scanner.nextLine();
                System.out.println("Ingrese la direccion del peligro:");
                String direccion = scanner.nextLine();
                System.out.println("Ingrese el barrio del peligro:");
                String barrio = scanner.nextLine();
                System.out.println("Ingrese la ciudad del peligro:");
                String ciudad = scanner.nextLine();
                System.out.println("Ingrese la provincia del peligro:");
                String provincia = scanner.nextLine();
                relevandoApp.getCategoriaController().mostrarCategorias();
                System.out.println("Ingrese el id de categoría del peligro:");
                Integer categoriaId = scanner.nextInt();
                relevandoApp.getResponsableController().mostrarResponsables();
                System.out.println("Ingrese el id de responsable del peligro:");
                Integer responsableId = scanner.nextInt();
                
                
                peligroController.crearPeligro(titulo, descripcion,direccion,barrio,ciudad,provincia,responsableId,categoriaId);
                
                break;
            case 2:
            	peligroController.mostrarPeligros();
                break;
            case 3:
            	peligroController.mostrarPeligros();
                System.out.println("Ingrese el ID del peligro:");
                id = scanner.nextInt();
                
                System.out.println("ID del peligro ingresado: "+id);
         
                PeligroSingleView  menuPeligroSingle = new PeligroSingleView(this.relevandoApp,id);
                menuPeligroSingle.iniciarMenu();
                
            
                break;
            case 4:
                System.out.println("Ingrese el ID del peligro a modificar:");
                int idModificar = scanner.nextInt();
                scanner.nextLine(); 

                System.out.println("Ingrese el nuevo título del peligro:");
                String tituloModificado = scanner.nextLine();
                System.out.println("Ingrese la nueva descripción del peligro:");
                String descripcionModificada = scanner.nextLine();
                System.out.println("Ingrese la nueva dirección del peligro:");
                String direccionModificada = scanner.nextLine();
                System.out.println("Ingrese el nuevo barrio del peligro:");
                String barrioModificado = scanner.nextLine();
                System.out.println("Ingrese la nueva ciudad del peligro:");
                String ciudadModificada = scanner.nextLine();
                System.out.println("Ingrese la nueva provincia del peligro:");
                String provinciaModificada = scanner.nextLine();

                relevandoApp.getCategoriaController().mostrarCategorias();
                System.out.println("Ingrese el nuevo ID de categoría del peligro:");
                Integer categoriaIdModificado = scanner.nextInt();
                scanner.nextLine(); 

                relevandoApp.getResponsableController().mostrarResponsables();
                System.out.println("Ingrese el nuevo ID de responsable del peligro:");
                Integer responsableIdModificado = scanner.nextInt();
                scanner.nextLine(); 

                peligroController.editarPeligro(idModificar, tituloModificado, descripcionModificada, direccionModificada, barrioModificado, ciudadModificada, provinciaModificada, responsableIdModificado, categoriaIdModificado);

                break;
            case 5:
                System.out.println("Ingrese el ID del peligro:");
                id = scanner.nextInt();
                peligroController.eliminarPeligro(id);
                break;
            case 6:
                System.out.println("Volviendo al Menú Principal...");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    @Override
    protected boolean esOpcionSalir(int opcion) {
        return opcion == 6; 
    }
}
