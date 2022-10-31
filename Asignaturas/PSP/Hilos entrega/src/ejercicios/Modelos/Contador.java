package ejercicios.Modelos;
import ejercicios.Ejercicio11;
import ejercicios.Ejercicio12;
import ejercicios.Modelos.Interfaces.IConsumidor;

public class Contador {
    private static int cont = -1;
    private int myCont = 0;
    int numer = 0;
    IConsumidor ejercicio;
    public Contador(int numero, IConsumidor ejercicio){
        cont+=1;
        myCont = cont;
        numer = numero;
        this.ejercicio = ejercicio;
        run();
    }

    public void run() {
        while(true){
            try {
                if (ejercicio.Consumir(myCont,"C"+myCont, numer, true)){
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
