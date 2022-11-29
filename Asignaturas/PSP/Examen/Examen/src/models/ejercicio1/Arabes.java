package models.ejercicio1;

public class Arabes {
    String nombre;
    int vida;
    Cristianos[] cristianos;

    int dañoARecibir = 0;

    public Arabes(String nombre, int vida, Cristianos[] cristianos){
        this.nombre = nombre;
        this.vida = vida;
        this.cristianos = cristianos;
    }

    public synchronized String Atacar(Cristianos cristianos){
        int ataque = (int)(Math.random()*70);
        String resultado = this.nombre+" Ataca con ..: "+ataque+"\n";
        cristianos.dañoARecibir = ataque;
        cristianos.notify();
        return resultado;
    }

    public synchronized String recibirDaño(Cristianos cristianos) throws InterruptedException {

        if ((vida - dañoARecibir) > 0){
            vida =- dañoARecibir;
            return this.nombre+" "+vida+" - "+" "+this.dañoARecibir+" = "+(vida-this.dañoARecibir)+ "vida";
        }
        return nombre+" MUERTO";
    }

    public synchronized void run() {
        Cristianos c = this.cristianos[random()];
        System.out.println(Atacar(c));
        try {
            wait();
            System.out.println(recibirDaño(c));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private int random(){
        return (int)(Math.random()*3);
    }
}
