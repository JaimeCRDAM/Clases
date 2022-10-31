package prueba;

import java.io.File;

public class Ejercicio_1 {
    public Ejercicio_1(String[] args){
        File f=new File(args[0]);
        String[] archivos = f.list();
        assert archivos != null;
        for (String archivo : archivos) {
            System.out.println(archivo);
        }
    }

}
