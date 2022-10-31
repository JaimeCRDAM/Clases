package ejercicios.Modelos;

import ejercicios.Modelos.Interfaces.ISort;

public class BubbleSort implements ISort {
    public BubbleSort(){
    }
    @Override
    public void start(int[] arrayInt) {
        var timeStart = System.nanoTime();
        sort(arrayInt);
        System.out.println("BubbleSort ha tardado: "+(System.nanoTime()-timeStart) + " nano segundos");

    }

    void sort(int arr[]) //https://www.geeksforgeeks.org/bubble-sort/
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
}
