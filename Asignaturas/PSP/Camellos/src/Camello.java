import java.util.Random;

public class Camello extends Thread{
    int numero;
    int[] posiciones;

    public Camello(int numero, int[] posiciones){
        this.numero = numero;
        this.posiciones = posiciones;
    }

    @Override
    public void run() {
        int ganador = -1;
        while(ganador == -1){
            int aux = new Random().nextInt(1,5);
            this.posiciones[this.numero] += aux*5;
            ganador = checkGanador();
        }

        if(this.posiciones[this.numero] >= 100 && ganador == this.numero){
            System.out.println("He ganado yo! Camello numero "+this.numero);
        }
    }

    private int checkGanador(){
        for (int i = 0; i < this.posiciones.length; i++) {
            if(this.posiciones[i] >= 100){
                return i;
            }
        }
        return -1;
    }
}
