package src.Recursion10.Recursion4_PatternsAndSorting;

import java.util.Arrays;

public class BubbleSortInRecursion_2 {
    public static void main(String[] args) {
        BubbleSortInRecursion_2 ob=new BubbleSortInRecursion_2();

        int[] arr={9,8,7,6,5,4,3,2,1};
        ob.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    void bubbleSort(int[] arr){
        helper(arr, arr.length-1,arr.length-2, false);
    }
    void helper(int[] arr, int i, int j, boolean isSwapped){
        if (i==0){
            return;
        }
        //this will execute after a single pass of j
        if (j< arr.length-i-1){
            if (!isSwapped){
                return;    //If isSwapped=false then this means the array is not swapped in the
                           //previous pass, it means the array is sorted so return.
            }
            helper(arr, --i, arr.length-2,false);
            return;
        }
        if (arr[j]>arr[j+1]){
            isSwapped=true; //this makes isSwapped=true only if the arr swapped in one pass
            swap(arr,j);
        }
        helper(arr, i, --j,isSwapped);
    }
    void swap(int[] arr, int j){
        int temp=arr[j];
        arr[j]=arr[j+1];
        arr[j+1]=temp;
    }

}
