package src.binarySearchIn2DArray;

import java.util.Arrays;

//row and column wise sorted but not fully sorted
//TC: O(n)
public class RowColMatrix27 {
    public static void main(String[] args) {
//        int[][] arr={
//                {10,20,30,40},
//                {15,25,35,45},
//                {28,29,37,49}
//        };

        int[][] arr={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        int target = 15;
        System.out.println(Arrays.toString(search(arr,target)));
    }

    static int[] search(int[][] matrix,int target){
        int r=0;
        int c=matrix[r].length-1;

        while (r<matrix.length && c >=0){
            if(target==matrix[r][c]) {
                return new int[]{r,c};
            }else if(target>matrix[r][c]){
                r++;
            }else {
                c--;
            }
        }
        return new int[]{-1,-1};
    }
}
