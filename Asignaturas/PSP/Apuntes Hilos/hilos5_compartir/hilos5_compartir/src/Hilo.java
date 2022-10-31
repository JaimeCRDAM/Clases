public class Hilo extends Thread{
    public Hilo(String name){
        super(name);
    }
    public void run(){
        try {
            for (int i=0;i<10;i++) {

                    System.out.println("Soy el hilo" + this.getName() + " ejecutandome");
                    Thread.sleep(500);

            }
        }catch (InterruptedException e){

        }
    }
}
