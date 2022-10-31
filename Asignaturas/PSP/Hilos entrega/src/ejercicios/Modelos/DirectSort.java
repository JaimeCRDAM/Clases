package ejercicios.Modelos;

import ejercicios.Modelos.Interfaces.ISort;

public class DirectSort implements ISort {
    public DirectSort(){
    }
    @Override
    public void start(int[] arrayInt) {
        var timeStart = System.nanoTime();
        sort(arrayInt);
        System.out.println("DirectSort ha tardado: "+(System.nanoTime()-timeStart) + " nano segundos");
    }

    public static void sort(int[] values) {//https://ofstack.com/Java/7259/java-direct-insert-sort-example.html
        int temp;
        int j = 0;
        for (int i = 1; i < values.length; i++) {
            if(values[i]<values[i-1])//The judgment is important here, which shows why insertion sort is faster than bubble sort and selection sort.
            {
                temp = values[i];
                //Data moves back
                for (j=i-1; j>=0 && temp<values[j]; j--)
                {
                    values[j+1] =values[j];
                }
                //Insert the data into the j+1 position
                values[j+1] =temp;
            }
        }
    }
}
