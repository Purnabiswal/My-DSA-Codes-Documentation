package src.Sorting;

import java.util.Arrays;

//TC: Worst: O(n^2), Best: O(n^2)
public class SelectionSort_2 {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr){
        int m;
        for(int i=0;i<arr.length-1;i++){
            //last position
            int last=arr.length-i-1;
            m=0;
            //finding maximum
            for (int j=1;j<arr.length-i;j++){
                if(arr[m]<arr[j]){
                    m=j;
                }
            }
            int t=arr[last];
            arr[last]=arr[m];
            arr[m]=t;
        }
    }

}
