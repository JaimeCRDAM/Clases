import models.ejercicio1.Batalla;
import models.ejercicio3.Engañar;
import models.ejercicio3_2.Abanderado;
import models.ejercicio3_2.Hondear;

import java.io.IOException;

public class Main {
    //Jaime Cano Ramos
    public static void main(String[] args) throws IOException, InterruptedException {
        Ejercicio3();
    }

    private static void Ejercicio3() throws IOException {
        new Engañar();
    }

    private static void Ejercicio3_2(){
        Hondear h = new Hondear();
        new Thread(){
            @Override
            public void run() {
                try {
                    new Abanderado("cristiano", h);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    new Abanderado("moro", h);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();
    }

    private static void Ejercicio1(){
        new Batalla();
    }


}