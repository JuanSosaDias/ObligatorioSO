package algoritmosso;

class Consumidor extends Thread {

    private Cola cola;

    Consumidor(Cola cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Desencolar un número de la cola
                int valor = cola.desencolar();

                // Imprimir el número desencolado
                System.out.println("Consumidor: " + valor);

                // Esperar un segundo
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
