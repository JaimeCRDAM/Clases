public class Hilo_Clase extends Thread{
    private Numero obj_1;
    public Hilo_Clase(String nombre, Numero m) {
        super(nombre);
        this.obj_1 = m;
    }
    public void run(){
        if (this.getName().equals("A")){
            this.obj_1.setNum(this.obj_1.getNum()+4);
        }else{
            this.obj_1.setNum(this.obj_1.getNum()+2);
        }
        System.out.println("Soy el hilo " + this.getName() + " finalizado. La variable numero vale para mi:" + this.obj_1.getNum());
    }
}
