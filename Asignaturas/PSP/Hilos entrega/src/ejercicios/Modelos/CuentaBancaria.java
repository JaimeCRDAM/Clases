package ejercicios.Modelos;

public class CuentaBancaria {
    public int saldo = 200;
    private synchronized void interactuarCuenta(int cantidad){
        if (cantidad < 0 && (saldo+cantidad >= 0)){
            saldo = saldo+cantidad;
            return;
        }
        if (cantidad < 0) return;
        saldo = saldo+cantidad;
    }

    public void ingresar(int cantidad){
        interactuarCuenta(cantidad);
    }
    public void retirar(int cantidad){
        if(cantidad > 0) return;
        interactuarCuenta(cantidad);
    }
}
