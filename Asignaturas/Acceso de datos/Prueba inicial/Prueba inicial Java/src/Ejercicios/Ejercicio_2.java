package Ejercicios;

public class Ejercicio_2 {
    public Ejercicio_2(){
        for (int i = 1; i <= 10; i++) {
            String string = String.format("5*%s=%s",i, i*5);
            System.out.println(string);
        }
    }
}
