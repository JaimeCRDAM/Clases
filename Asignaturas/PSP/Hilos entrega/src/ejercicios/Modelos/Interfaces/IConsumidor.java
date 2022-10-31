package ejercicios.Modelos.Interfaces;

public interface IConsumidor {
    public boolean Consumir(int numero, String nombre, int consumir, boolean sync) throws InterruptedException;
}
