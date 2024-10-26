package ar.nix.relevando;

import ar.nix.relevando.views.MenuPrincipal;
import ar.nix.relevando.controllers.CategoriaController;
import ar.nix.relevando.controllers.ResponsableController;
import ar.nix.relevando.controllers.TramiteController;
import ar.nix.relevando.controllers.PeligroController;

public class Relevando {

	
	private CategoriaController categoriaController;
	private PeligroController peligroController;
	private ResponsableController responsableController;
	private TramiteController tramiteController;
	
	
    public Relevando() {
    	this.initApp();
    }
    

    public void initApp() {
    	
       //Instancia todos los controladores
 	   setCategoriaController(new CategoriaController());
 	   setPeligroController(new PeligroController());
 	   setResponsableController(new ResponsableController());
 	   setTramiteController(new TramiteController(this));
 	   
 	   //Inicia el menu principal
 	   MenuPrincipal menuPrincipal = new MenuPrincipal(this);
       menuPrincipal.iniciarMenu();
    }


	public CategoriaController getCategoriaController() {
		return categoriaController;
	}


	public void setCategoriaController(CategoriaController categoriaController) {
		this.categoriaController = categoriaController;
	}


	public PeligroController getPeligroController() {
		return peligroController;
	}


	public void setPeligroController(PeligroController peligroController) {
		this.peligroController = peligroController;
	}


	public ResponsableController getResponsableController() {
		return responsableController;
	}


	public void setResponsableController(ResponsableController responsableController) {
		this.responsableController = responsableController;
	}


	public TramiteController getTramiteController() {
		return tramiteController;
	}


	public void setTramiteController(TramiteController tramiteController) {
		this.tramiteController = tramiteController;
	}

}
