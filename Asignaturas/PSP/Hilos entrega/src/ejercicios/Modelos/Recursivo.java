package ejercicios.Modelos;

public class Recursivo extends Thread {

    public void run(){
        long startTime = System.currentTimeMillis();
        int factorial = factorial(5);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(factorial+" "+estimatedTime);
    }

    private int factorial(int numeroFactorial){
        int numero = numeroFactorial;
        if(numero <= 1){
            return 1;
        }
        return numero*factorial(numero-1);
    }
}
