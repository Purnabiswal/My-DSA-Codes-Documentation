package src.Sorting;

import java.util.Arrays;

//TC: Worst: O(n^2), Best: O(n)
public class BubbleSort_1 {
    public static void main(String[] args) {
        int[] arr={-1,-56,500,-32,94,2,64,78,0};

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    static void bubbleSort(int[] arr){

        boolean isSwapped;

        //run the steps n-1 times
        for(int i=0;i<arr.length-1;i++){
            isSwapped=false;
            //for each step, max item will come at the last respective index
            for (int j=1;j<arr.length-i;j++){
                if (arr[j]<arr[j-1]){
                    //swap if the item is smaller than the previous item
                    int t=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=t;
                    isSwapped=true;
                }
            }
            //if you did not swap for a particular value of i, it means the array is sorted hence stop the program.
            if(!isSwapped) {
                break;
            }
        }


    }
}
