package ejercicios;

import ejercicios.Modelos.Contador;
import ejercicios.Modelos.Interfaces.IConsumidor;

public class Ejercicio12 implements IConsumidor {
    int numero;
    int cont = 0;
    IConsumidor clase = this;
    public Ejercicio12() throws InterruptedException {
        new Thread(){
            @Override
            public void run() {

            }
        }.start();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                new Thread(){
                    @Override
                    public void run() {
                        new Contador(numero, clase);
                    }
                }.start();
            }
            if (i%2==0){
                Proveedor2();
                continue;
            }
            Proveedor();
        }
    }
    private void Proveedor(){

        numero =  18;
    }
    private void Proveedor2(){

        numero =  27;
    }
    @Override
    public boolean Consumir(int numero, String nombre, int consumir, boolean sync) throws InterruptedException {
        if (cont != numero || sync) return false;
        System.out.println("Hilo: "+nombre+" consume el numero: "+consumir);
        cont++;
        return true;
    }
}
