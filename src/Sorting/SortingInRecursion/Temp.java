package src.Sorting.SortingInRecursion;

import java.util.Arrays;

public class Temp {
    public static void main(String[] args) {
        Temp ob = new Temp();
        int[] arr = {8, 9, 7, 6, 5, 8, 35, 19, 2};
        ob.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing last element as pivot
        int s = low;
        int e = high - 1; // Start `e` one step before `high`

        while (s <= e) { // Fix condition to avoid infinite loop
            while (s <= e && arr[s] <= pivot) { // Prevent out-of-bounds
                s++;
            }
            while (s <= e && arr[e] > pivot) {
                e--;
            }
            if (s < e) {
                swap(arr, s, e);
            }
        }

        swap(arr, s, high); // Place pivot correctly
        return s; // Return new pivot position
    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
