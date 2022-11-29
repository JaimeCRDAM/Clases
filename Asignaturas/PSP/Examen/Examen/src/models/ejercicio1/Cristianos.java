package models.ejercicio1;


public class Cristianos {
    String nombre;
    int vida;
    Arabes[] Arabes;

    int dañoARecibir = 0;

    public Cristianos(String nombre, int vida, Arabes[] Arabes){
        this.nombre = nombre;
        this.vida = vida;
        this.Arabes = Arabes;
    }

    public synchronized String Atacar(Arabes arabe){
        int ataque = (int)(Math.random()*70);
        String resultado = this.nombre+" Ataca con ..: "+ataque+"\n";
        arabe.dañoARecibir = ataque;
        arabe.notify();
        return resultado;
    }

    public synchronized String recibirDaño(Arabes arabe) throws InterruptedException {
        if ((vida - dañoARecibir) > 0){
            vida =- dañoARecibir;
            return this.nombre+" "+vida+" - "+" "+this.dañoARecibir+" = "+(vida-this.dañoARecibir)+ "vida";
        }
        return nombre+" MUERTO";
    }

    public synchronized void  run() {
        Arabes a = this.Arabes[random()];
        System.out.println(Atacar(a));
        try {
            wait();
            System.out.println(recibirDaño(a));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private int random(){
        return (int)(Math.random()*3);
    }
}
