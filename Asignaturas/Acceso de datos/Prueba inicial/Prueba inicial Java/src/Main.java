import Ejercicios.Ejercicio_1;

import java.io.File;
import java.util.*;

/*
Prototipo para tener todos los ejercicios de OOP en un mismo proyecto mientras que se mantiene la individualidad de cada uno
V1: Release inicial
V2: Obtencion de los nombres basandose en los archivos presentes
V3: Añadido error stacktrace
V4: Añadido debug check
*/

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean debug = areWeDebugging();
        boolean ak = false;
        new Ejercicio_1();
        if (ak) {
            while(true){
                System.out.println();
                System.out.println("Los ejercicios disponibles son:");
                System.out.println();

                String[] ejercicios = ejerciciosDisponibles();
                for (int i = 0; i < ejercicios.length; i++) {
                    System.out.println(ejercicios[i]);
                }
                System.out.println();
                System.out.println();

                System.out.println("Escribe el nombre del ejercicio que quieras.");
                String clase = sc.nextLine();

                try {
                    Class<?> c = Class.forName("Ejercicios."+clase);
                    c.getDeclaredConstructor().newInstance();

                }
                catch (Exception e) {
                    if (debug){
                        e.printStackTrace();
                    } else{
                        System.err.println("Has escrito mal el ejercicio");
                    }
                }
                System.out.print("");
            }
        }
    }

    private static String[] ejerciciosDisponibles(){
        String[] ejercicios;
        final File folder = new File("src/Ejercicios");
        int counter = 0;
        for (final File fileEntry : folder.listFiles()) {
            String nombre = fileEntry.getName();
            if(nombre.indexOf(".java") > 0){
                counter++;
            }
        }

        ejercicios = new String[counter];
        counter = 0;

        for (final File fileEntry : folder.listFiles()) {
            String nombre = fileEntry.getName();
            if(nombre.indexOf(".java") > 0){
                ejercicios[counter] = nombre.substring(0, nombre.indexOf("."));
                counter++;
            }
        }

        Arrays.sort(ejercicios);
        return ejercicios;
    }

    private static boolean areWeDebugging(){
        String user = System.getProperty("user.name");
        if(user.indexOf("dam") >= 0 || user.indexOf("Lnote") >= 0){
            return true;
        }

        return false;
    }
}