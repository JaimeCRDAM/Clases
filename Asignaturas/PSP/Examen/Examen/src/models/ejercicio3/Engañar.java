package models.ejercicio3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Engañar {

    public Engañar() throws IOException {
        PipedInputStream tuberiaCristianaIn = new PipedInputStream();
        PipedInputStream tuberiaArabeIn = new PipedInputStream();
        PipedOutputStream tuberiaCristianaOut = new PipedOutputStream(tuberiaArabeIn);
        PipedOutputStream tuberiaArabeOut = new PipedOutputStream(tuberiaCristianaIn);
        JefeCristiano Cristiano = new JefeCristiano(3, tuberiaCristianaIn, tuberiaCristianaOut);
        JefeMoro moro = new JefeMoro(3, tuberiaArabeIn, tuberiaArabeOut);
        Cristiano.start();
        moro.start();
    }
}
