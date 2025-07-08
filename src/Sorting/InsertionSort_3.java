package src.Sorting;

import java.util.Arrays;

//TC: Worst: O(n^2), Best: O(n)
//insertion sort is "stable"
public class InsertionSort_3 {
    public static void main(String[] args) {
        int[] arr={1,-5,-68,54,0,1,-99,522};
        insertionSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    static void insertionSort(int[] arr){
        for (int i=0;i< arr.length-1;i++){ // "i" will go till n-1 that is: i<=arr.length-2 or i< arr.length-1
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int t=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=t;
                }else { // if j>j-1 then break, because the previous array is already sorted
                    break;
                }
            }
        }
    }

}
