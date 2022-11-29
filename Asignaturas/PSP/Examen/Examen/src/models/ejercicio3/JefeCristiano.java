package models.ejercicio3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class JefeCristiano extends Thread{
    PipedOutputStream outPipe;
    PipedInputStream inputPipe;
    public JefeCristiano(int numero, PipedInputStream pipe, PipedOutputStream pipe2) throws IOException {
        this.inputPipe = pipe;
        this.outPipe = pipe2;
    }
    @Override
    public void run(){
        try {
            while(true){
                if (inputPipe.available() > 0){
                    System.out.println("Moros han escrito: "+(char)inputPipe.read());
                    outPipe.write("Han muerto 10 guerreros".getBytes());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
