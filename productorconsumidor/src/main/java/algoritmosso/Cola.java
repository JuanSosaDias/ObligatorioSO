package algoritmosso;

import java.util.concurrent.Semaphore;

class Cola {

    private int[] pool;
    private int inicio;
    private int fin;
    private int capacidad;
    private Semaphore semaforo;

    Cola(int capacidad) {
        this.pool = new int[capacidad];
        this.inicio = 0;
        this.fin = 0;
        this.capacidad = capacidad;
        this.semaforo = new Semaphore(capacidad);
    }

    void encolar(int valor) throws InterruptedException {
        semaforo.acquire();
        this.pool[this.fin++] = valor;
        if (this.fin == this.capacidad) {
            this.fin = 0;
        }
        semaforo.release();
    }

    int desencolar() throws InterruptedException {
        semaforo.acquire();
        int valor = this.pool[this.inicio++];
        if (this.inicio == this.capacidad) {
            this.inicio = 0;
        }
        semaforo.release();
        return valor;
    }
}