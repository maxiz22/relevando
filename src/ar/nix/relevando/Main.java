package ar.nix.relevando;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	 Scanner scanner = new Scanner(System.in);
         int option;

         do {
             // Mostrar las opciones del menú
             System.out.println("\n===== Menú Principal =====");
             System.out.println("1. Opción 1 - Saludar");
             System.out.println("2. Opción 2 - Mostrar la hora actual");
             System.out.println("3. Opción 3 - Calcular suma de dos números");
             System.out.println("4. Salir");
             System.out.print("Selecciona una opción: ");

             // Leer la opción seleccionada por el usuario
             option = scanner.nextInt();

             // Procesar la opción seleccionada
             switch (option) {
                 case 1:
                     saludar();
                     break;
                 case 2:
                     mostrarHoraActual();
                     break;
                 case 3:
                     calcularSuma(scanner);
                     break;
                 case 4:
                     System.out.println("Saliendo del programa...");
                     break;
                 default:
                     System.out.println("Opción no válida. Intenta de nuevo.");
             }

         } while (option != 4); // Repite el menú hasta que el usuario elija salir

         scanner.close();
    }
    
    // Método para la opción 1
    private static void saludar() {
        System.out.println("¡Hola, usuario! ¿Cómo estás?");
    }

    // Método para la opción 2
    private static void mostrarHoraActual() {
        System.out.println("La hora actual es: " + java.time.LocalTime.now());
    }

    // Método para la opción 3
    private static void calcularSuma(Scanner scanner) {
        System.out.print("Ingresa el primer número: ");
        int num1 = scanner.nextInt();
        System.out.print("Ingresa el segundo número: ");
        int num2 = scanner.nextInt();
        int suma = num1 + num2;
        System.out.println("La suma de " + num1 + " y " + num2 + " es: " + suma);
    }
    
}
