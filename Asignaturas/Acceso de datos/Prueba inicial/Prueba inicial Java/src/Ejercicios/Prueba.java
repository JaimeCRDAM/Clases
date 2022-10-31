package Ejercicios;

import java.io.File;
import java.io.FileReader;

public class Prueba {
    public Prueba() {
        try {
            File fichero = new File("src/Ejercicios/prueba2.txt");
            FileReader f = new FileReader(fichero);
            String cosa;
            int i;
            char cadena[] = new char[20];
            do {
                i = f.read();
                System.out.print((char) (i));
            } while (i != -1);
            f.close();
            f = new FileReader(fichero);
            do {
                i = f.read(cadena);
                for (int j = 0; j < i; j++) {
                    System.out.print((char) cadena[j]);
                }
            } while (i != -1);
        } catch (Exception e){

        }
    }
}
