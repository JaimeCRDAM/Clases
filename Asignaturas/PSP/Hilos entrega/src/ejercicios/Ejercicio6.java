package ejercicios;

import ejercicios.Modelos.ContarLetras;
import ejercicios.Modelos.ContarLineas;

import java.io.IOException;

public class Ejercicio6 {
    public Ejercicio6() throws IOException {
        new ContarLetras().run('a');
        new ContarLineas().run();
    }

}
