package ejercicios;
import ejercicios.Modelos.Contador;
import ejercicios.Modelos.Escritor;

import java.sql.SQLOutput;
import java.util.concurrent.Semaphore;

public class Ejercicio13 {
    String[] letras = {"A","B","C"};
    int cont = 0;
    Semaphore sem = new Semaphore(1, true);
    Ejercicio13 clase = this;
    public Ejercicio13(){
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(){
                @Override
                public void run() {
                    new Escritor(letras[finalI], clase);
                }
            }.start();
        }
    }

    public boolean escribir(String letra) throws InterruptedException {
        if (cont >= 3){
            cont = 0;
        }
        if(letra.equals(letras[cont])){
            sem.acquire();
            System.out.print(letra);
            cont++;
            sem.release();
        }
        return false;
    }
}
