package models.ejercicio1;

public class Batalla {
    Cristianos[] cristianos = new Cristianos[3];
    Arabes[] arabes = new Arabes[3];
    Integer cristianosvivos = 3;
    Integer arabesvivos = 3;

    Boolean turno = true;

    public Batalla(){
        for (int i = 0; i < 3; i++) {
            cristianos[i] = new Cristianos("cristiano_"+(i+1), 100, arabes);
            arabes[i] = new Arabes("    arabe_"+(i+1), 100, cristianos);
        }
        Simulacion();
    }

    private void Simulacion(){
        while(arabesvivos > 0 && cristianosvivos > 0){
            Thread a = new Thread(() -> cristianos[random()].run());
            Thread c = new Thread(() -> arabes[random()].run());
            c.start();
            a.start();
            for (int i = 0; i < cristianos.length; i++) {
                if(cristianos[i].vida <= 0){
                    cristianosvivos=-1;
                }
            }
            for (int i = 0; i < cristianos.length; i++) {
                if(arabes[i].vida <= 0){
                    arabesvivos=-1;
                }
            }
        }
    }
    private int random(){
        return (int)(Math.random()*3);
    }

    static public synchronized void a(Object object){
        object.notify();
    }
}
