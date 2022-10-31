package Ejercicios;

public class Ejercicio_1 {

    public Ejercicio_1(){
        for (int i = 1; i <= 100; i++) {
            if(i%2 != 0) continue;
            String string = String.format("%s ", i);
            System.out.print(string);
        }
    }
}
