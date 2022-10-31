package Ejercicios;

import java.util.Scanner;

public class Ejercicio_3 {
    public Ejercicio_3(){
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            String string = String.format("%s*%s=%s",numero, i, i*numero);
            System.out.println(string);
        }
    }
}
