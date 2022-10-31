package ejercicios.Modelos;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContarLineas {

    public void run() throws IOException {
        File f = new File("src/Ejercicios/zi.txt");
        FileReader fr = new FileReader(f);
        int contador = 0;
        int content;
        while ((content = fr.read()) != -1) {
            if(content == 10) {
                contador++;
            }
        }
        System.out.println(contador);
        fr.close();
    }
}
