package models.ejercicio3_2;

import java.util.concurrent.Semaphore;

public class Abanderado {
    String nombre;
    public Abanderado(String nombre, Hondear hondear) throws InterruptedException {
        this.nombre = nombre;
        for (int i = 0; i < 3; i++) {
            hondear.hondearBandera(this);
        }
    }
}
