package ar.nix.relevando.views;

import ar.nix.relevando.Relevando;

public class MenuPrincipal extends Menu {
	
	
	private Relevando relevandoApp;
	public MenuPrincipal(Relevando relevandoApp) {
		this.relevandoApp = relevandoApp;
	}
	
	
  @Override
    protected void mostrarOpciones() {
        System.out.println("----- Menú Principal -----");
        System.out.println("1. Gestión de Peligros");
        System.out.println("2. Gestión de Trámites");
        System.out.println("3. Gestión de Responsables");
        System.out.println("4. Gestión de Categorías");
 
    }

    @Override
    protected void procesarOpcion(int opcion) {
        switch (opcion) {

            case 1:
            	  PeligroView menuPeligros = new PeligroView(relevandoApp.getPeligroController());
            	  menuPeligros.iniciarMenu();
                  break;
            case 2:
                TramiteView menuTramite = new TramiteView(relevandoApp.getTramiteController(),null);
                menuTramite.iniciarMenu();
                break;
            case 3:
                ResponsableView menuResponsable = new ResponsableView(relevandoApp.getResponsableController());
                menuResponsable.iniciarMenu();
                break;
            case 4:
                CategoriaView  menuCategoria = new CategoriaView(relevandoApp.getCategoriaController());
                menuCategoria.iniciarMenu();
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    @Override
    protected boolean esOpcionSalir(int opcion) {
        return opcion == 5;
    }
}
