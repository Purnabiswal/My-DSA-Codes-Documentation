package src.Sorting;

import java.util.Arrays;

//TC: Worst: O(n), Best: O(n)
public class CycleSort32 {
    public static void main(String[] args) {
        int[] arr={9,6,4,2,3,5,7,1,8}; //array should be continuous
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cycleSort(int[] arr){
        int i=0;
        while(i<arr.length-1){
            int correct=arr[i]-1; //correct index
            if(i!=correct){ //checking the element is at its correct position or not
                int t=arr[i];
                arr[i]=arr[correct];
                arr[correct]=t;
            }else {
                i++;
            }
        }
    }
}
