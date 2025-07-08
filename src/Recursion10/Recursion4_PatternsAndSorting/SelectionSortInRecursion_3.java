package src.Recursion10.Recursion4_PatternsAndSorting;

import java.util.Arrays;

public class SelectionSortInRecursion_3 {
    public static void main(String[] args) {
        SelectionSortInRecursion_3 ob=new SelectionSortInRecursion_3();
        int[] arr={5,6,8,4,99,4,58,7,565,58,72,1};
        ob.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] arr){
        helper(arr,0,0,0);
    }

    void helper(int[] arr, int i, int j, int m){
        if (i==arr.length-1){
            return;
        }
        if (arr[m]<arr[j]){
            m=j;
        }
        if (j==arr.length-i-1){
            int temp =arr[arr.length-i-1];
            arr[arr.length-i-1]=arr[m];
            arr[m]=temp;
            helper(arr, i+1, 0, 0);
            return;
        }
        helper(arr, i, j+1, m);
    }
}
