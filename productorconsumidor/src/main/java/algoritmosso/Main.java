package algoritmosso;

import java.util.LinkedList;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

class ProdCons {


    private LinkedList<Integer> almacen = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    


    private final int CAPACIDAD = scanner.nextInt();

    public synchronized void Producir () throws InterruptedException {
        int elemento = 1;
        while (true) {
            while (almacen.size()==CAPACIDAD) { //Si es array tenemos el largo y no ocupamos memoria al pedo
                wait();
            }
            System.out.println("Productor produce: " + elemento + " ° fruta");
            almacen.add(elemento);
            elemento ++;
            notify();
            Thread.sleep(1000);
        }

    }

    public synchronized void Consumir () throws InterruptedException {
        while (true) {
            while (almacen.isEmpty()) {
                wait();
            }
            int elemento = almacen.poll();
            System.out.println("Consumidor Consume "+ elemento + " ° fruta");
            notify();
            Thread.sleep(1000);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("HOLA, EMPEZEMOS A TRABAJAR EN NUESTRO SUPERMERCADO!");
        System.out.println("Ingrese la cantidad de su almacen: ");
        ProdCons pc = new ProdCons();
        Thread productor = new Thread( ()-> {
            try {
                pc.Producir();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } );
        Thread consumidor = new Thread ( () -> {
            try {
                pc.Consumir();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });
        productor.start();
        consumidor.start();
    }
}