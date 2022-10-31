public class Main {
    public static void main(String[] args) throws InterruptedException {
        /**
         // Ejemplo sencillo de hilos
        Hilo ha = new Hilo("hilo_A");
        Hilo hb = new Hilo("hilo_B");
        Hilo hc = new Hilo("hilo_C");

        ha.start();
        hb.start();
        hc.start();
        Thread.sleep(500);
        System.out.println("Soy el hilo principal");
         //Fin ejemplo sencillo de hilos
         **/

        /**probamos los ejercicios de variables locales
        int numero = 10;
        Hilo_Variable_Local ha = new Hilo_Variable_Local("A", numero);
        Hilo_Variable_Local hb = new Hilo_Variable_Local("B", numero);

        ha.start();
        hb.start();
        System.out.println("Soy el hilo main finalizado. Para mi la variable vale " + numero);
        //fin parte de variables locales**/

        //Probamos ejercicio de paso de un objeto
        Numero Obj_num = new Numero(0);
        Hilo_Clase ha_obj = new Hilo_Clase("A", Obj_num);
        Hilo_Clase hb_obj = new Hilo_Clase("B", Obj_num);

        ha_obj.start();
        hb_obj.start();
        System.out.println("Soy el hilo main finalizado. Para mi la variable vale " + Obj_num.getNum());
       //Probamos ejercicio de paso de un objeto **/
    }
}