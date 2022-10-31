public class Main {
    public static void main(String[] args) {

     Mihilo a = new Mihilo();
     Mihilo b = new Mihilo();

     a.start();
     b.start();

     //Primero, construye un objeto MihiloInterfaz.
     MihiloInterfaz c= new MihiloInterfaz();

     //Luego, construye un hilo de ese objeto.
     Thread c_aux=new Thread(c);
     c_aux.start();
    }

}