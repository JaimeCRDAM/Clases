package ejercicios.Modelos;

import ejercicios.Modelos.Interfaces.ISort;

public class QuickSort implements ISort {
    public QuickSort(){
    }

    @Override
    public void start(int[] arrayInt) {
        var timeStart = System.nanoTime();
        sort(arrayInt, 0, arrayInt.length-1);
        System.out.println("QuickSort ha tardado: "+(System.nanoTime()-timeStart) + " nano segundos");
    }
    static void sort(int[] arr, int low, int high)// https://www.geeksforgeeks.org/quick-sort/
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
