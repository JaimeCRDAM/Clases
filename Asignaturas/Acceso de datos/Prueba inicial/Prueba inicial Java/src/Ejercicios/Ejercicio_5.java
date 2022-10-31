package Ejercicios;

import java.util.Scanner;

public class Ejercicio_5 {
    public Ejercicio_5(){
        String letras[] = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        System.out.println(letras[numero%23]);
    }
}
