package src.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensional3 {
    public static void main(String[] args) {
        //int[][] arr=new int[3][];  // column size is not mandatory

//        int[][] arr={
//                {1,2,3}, //0th index
//                {4,5},  //1st index
//                {6,7,8,9}  //2nd index
//        };


        Scanner scan=new Scanner(System.in);
        int[][] arr=new int[3][2];


        for (int row=0;row<arr.length;row++){  //arr.length: gives number of rows
            //for each column in every row
            for (int col=0;col<arr[row].length;col++){
                arr[row][col]=scan.nextInt();
            }
        }

        //Printing by for loop
        for(int row=0;row<arr.length;row++){
            for (int col=0;col<arr[row].length;col++){
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();
        }

        //Printing by Array's class toString()
        for (int row=0;row<arr.length;row++){
            System.out.println(Arrays.toString(arr[row]));
        }

        //Printing by for each
        for (int[] row:arr){
            System.out.println(Arrays.toString(row));
        }


    }
}
