package ejercicios;

import ejercicios.Modelos.CuentaBancaria;

public class Ejercicio5 {
    public Ejercicio5(){
        CuentaBancaria cuenta = new CuentaBancaria();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> cuenta.ingresar(20));
            thread.run();
            if(i < 5) {
                thread = new Thread(() -> cuenta.retirar(-13));
                thread.run();
            }
        }
        System.out.println(cuenta.saldo);
    }
}
