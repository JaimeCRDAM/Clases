package ejercicios.Modelos;

public class Itinerativo extends Thread{

    public void run(int numeroFactorial){
        long startTime = System.currentTimeMillis();
        int numero = 1;

        for (int i = 1; i <= numeroFactorial; i++) {
            numero = numero * i;
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(numero+" "+estimatedTime);
    }
}
