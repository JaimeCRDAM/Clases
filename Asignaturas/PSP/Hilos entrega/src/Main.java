import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Prototipo para tener todos los ejercicios de OOP en un mismo proyecto mientras que se mantiene la individualidad de cada uno
V1: Release inicial
V2: Obtencion de los nombres basandose en los archivos presentes
V3: Añadido error stacktrace
V4: Añadido debug check
V5: Obtencion de clases usando reflection
*/

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InvokeEjercicio();
    }
    public static List<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toList());
    }

    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }

    private static void InvokeEjercicio() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        List<Class> ejercicios = findAllClassesUsingClassLoader("ejercicios");
        System.out.println("Ejercicios disponibles");
        ejercicios.forEach(ej ->
                System.out.println(ej)
        );
        String ejercicio = sc.nextLine();
        Class.forName(ejercicio).getDeclaredConstructor().newInstance();
    }
}