package ejercicios;

import ejercicios.Modelos.BubbleSort;
import ejercicios.Modelos.DirectSort;
import ejercicios.Modelos.Interfaces.ISort;
import ejercicios.Modelos.QuickSort;

import java.util.Random;

public class Ejercicio2 {
    int arrayInt[] = new int[1000];
    public Ejercicio2()  {
        try {
            PoblateArray();
            Thread t1 = MakeThreadWithClass(QuickSort.class);
            Thread t2 = MakeThreadWithClass(DirectSort.class);
            Thread t3 = MakeThreadWithClass(BubbleSort.class);
            t1.start();
            t2.start();
            t3.start();
        } catch (Exception e){
        }
    }

    private void PoblateArray(){
        Random random = new Random();
        random.setSeed(420);
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = random.nextInt(1, 1000);
        }
    }


    private <T extends ISort> Thread MakeThreadWithClass(Class<T> klass) {
        return new Thread(){
            @Override
            public void run(){
                try {
                   T klassInstance = klass.getDeclaredConstructor().newInstance();
                   klassInstance.start(arrayInt.clone());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        };
    }
}
