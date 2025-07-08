package src.Sorting.SortingInRecursion;

import java.util.Arrays;

//TC:
// Worst case: O(n*n)
// Average & Best case: O(nlog(n))
public class QuickSort_14 {
    public static void main(String[] args) {
        QuickSort_14 ob = new QuickSort_14();
        int[] arr = {8,9,7,6,5,8,35,19,2};
        //Arrays.sort(arr);
        ob.quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    void quickSort(int[] arr, int low, int high){
        if (low<high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    int partition(int[] arr, int low, int high){
        int pivot=arr[high];
        int s=low;
        int e= high-1;
        while(s<=e){
            //if the array is sorted, it will not swap
            while(s<=e && arr[s]<=pivot){
                s++;
            }
            while(s<=e && arr[e]>pivot ){
                e--;
            }
            if (s<e){
                swap(arr,s,e);
            }
        }

        swap(arr,s,high);
        return s;
    }

    void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }


}
