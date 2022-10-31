package ejercicios;
import ejercicios.Modelos.Contador;
import ejercicios.Modelos.Interfaces.IConsumidor;

public class Ejercicio11 implements IConsumidor{
    int numero = Proveedor();
    int cont = 0;
    IConsumidor clase = this;
    public Ejercicio11() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                new Thread(){
                    @Override
                    public void run() {
                        new Contador(numero, clase);
                    }
                }.start();
            }
            numero = Proveedor();
        }

    }
    private int Proveedor(){
        return (int) (Math.random() * 50);
    }
    @Override
    public boolean Consumir(int numero, String nombre, int consumir, boolean sync) throws InterruptedException {
        if (cont != numero && sync) return false;
        System.out.println("Hilo: "+nombre+" consume el numero: "+consumir);
        cont++;
        return true;
    }
}
