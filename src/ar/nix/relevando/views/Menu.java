package ar.nix.relevando.views;

import java.util.Scanner;

public abstract class Menu {

    protected Scanner scanner;
    
    public Menu() {
        this.scanner = new Scanner(System.in);
    }


    public void iniciarMenu() {
        int opcion;
        do {
            mostrarOpciones();
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            procesarOpcion(opcion);
        } while (!esOpcionSalir(opcion));
    }

    protected abstract void mostrarOpciones(); 
    protected abstract void procesarOpcion(int opcion);  
    protected abstract boolean esOpcionSalir(int opcion);  
    
}
