package src.Arrays;

import java.util.Arrays;

public class LSIn2DArray11 {
    public static void main(String[] args) {
        //LS: Linear search
        int[][] arr={
                {23,4,1},
                {18,12,33,9},
                {78,99,34,56},
                {18,102}
        };
        int target=56;
        int[] ans=search(arr,target);
        System.out.println("Index: "+Arrays.toString(ans));
        System.out.println("Max of 2D array: "+max(arr));
        System.out.println("Max of 2D array by for each: "+max2(arr));
    }

    //LS in 2D array:
    static int[] search(int[][] arr,int target){      //Create return type int[], if there are more than 1 value need to be return
        for (int row=0;row<arr.length;row++){         //Return the values in the array format
            for (int col=0;col<arr[row].length;col++){
                if (arr[row][col]==target){
                    int[] ans={row,col};
                    return ans;
                    //return new int[]{row,col};
                }
            }
        }
        return new int[]{-1};
    }

    //Find max in 2D array
    static int max(int[][] arr){
        int max=arr[0][0]; //Or int max=Integer.MIN_VALUE;

        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[row].length;col++){
                if (arr[row][col]>max){
                    max=arr[row][col];
                }
            }
        }
        return max;
    }
    //Find max in 2D array by for each
    static int max2(int[][] arr){
        int max=arr[0][0]; //Or int max=Integer.MIN_VALUE;

        for(int[] element1:arr){
            for(int element: element1){
                if (element>max){
                    max=element;
                }
            }

        }
        return max;
    }
}
