package models.ejercicio3_2;

import java.util.concurrent.Semaphore;

public class Abanderado {
    Semaphore sem = new Semaphore(1, true);
    public Abanderado(){
        
    }


    private void abanderar(){
        int i = 0;
        while(i < 3){

            i++;
        }
    }

    private void abanderado(String nombre){

    }

    private void hondear(String nombre){

    }

}
