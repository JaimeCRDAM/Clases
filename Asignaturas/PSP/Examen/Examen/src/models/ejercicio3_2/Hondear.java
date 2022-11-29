package models.ejercicio3_2;

import java.util.concurrent.Semaphore;

public class Hondear {

    Semaphore sem = new Semaphore(1, true);
    public Hondear(){

    }

    public void hondearBandera(Abanderado abanderado) throws InterruptedException {
        sem.acquire();
        System.out.println("abanderado: "+ abanderado.nombre);
        sem.release();
    }
}
