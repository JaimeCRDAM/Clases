public class Main {
    static int cantidad[];
    static Camello camello[] = new Camello[4];

    public static void main(String[] args) {
        cantidad = new int[4];
        int i = 4;
        for (int j = 0; j < i; j++) {
            camello[j] = new Camello(j, cantidad);
        }

        for (int j = 0; j < i; j++) {
            camello[j].start();
        }
    }

    public static boolean hanTerminadoTodos(){
        int a = 0;
        while(a <4){
            for (int j = 0; j < 4; j++) {
                if(!camello[j].isAlive()){
                    a++;
                }
            }
        }
        return true;
    }
}