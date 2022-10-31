package ejercicios.Modelos;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContarLetras extends Thread{
    public void run(char letra) throws IOException {
        File f = new File("src/Ejercicios/zi.txt");
        FileReader fr = new FileReader(f);
        int contador = 0;
        int content;
        while ((content = fr.read()) != -1) {
            if(((char)content) == letra) {
                contador++;
            }
        }
        System.out.println(contador);
        fr.close();
    }
}
