package algoritmosso;

class Productor extends Thread {

    private Cola cola;

    Productor(Cola cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Obtener un número aleatorio
                int valor = (int) (Math.random() * 100);

                // Encolar el número en la cola
                cola.encolar(valor);

                // Imprimir el número encolado
                System.out.println("Productor: " + valor);

                // Esperar un segundo
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
