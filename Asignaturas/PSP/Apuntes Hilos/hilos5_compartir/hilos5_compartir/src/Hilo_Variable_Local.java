public class Hilo_Variable_Local extends Thread{
    private int num=0;
    public Hilo_Variable_Local(String name, int numero){
        super(name);
        this.num = numero;
    }
    public void run(){
        if (this.getName().equals("A")){
            this.num +=4;
        }else{
            this.num +=2;
        }
        System.out.println("Soy el hilo " + this.getName() + " finalizado. La variable numero vale para mi:" + this.num);
    }
}
