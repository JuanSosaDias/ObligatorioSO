package algoritmosso;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Crear la cola
    Cola cola = new Cola(100);

    // Crear el objeto que hará la pregunta
    Scanner scanner = new Scanner(System.in);

    // Bucle infinito para hacer la pregunta
    while (true) {
        try {
            // Preguntar al usuario si desea consumir o producir
            System.out.print("¿Desea consumir (c) o producir (p)? ");
            String opcion = scanner.nextLine();

            // Si el usuario desea consumir
            if (opcion.equals("c")) {
                // Crear un nuevo hilo consumidor
                new Consumidor(cola).start();
            } else if (opcion.equals("p")) {
                // Crear un nuevo hilo productor
                new Productor(cola).start();
            } else {
                // Opción no válida
                System.out.println("Opción no válida.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
}