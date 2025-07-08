package src.Sorting.Assignments;

import java.util.Arrays;
//https://leetcode.com/problems/two-sum/description/
//solve again with 0ms
public class TwoSum {
    public static void main(String[] args) {
        int[] arr={2,7,11,15};
        //System.out.println(Arrays.toString(twoSum(arr,6)));
        System.out.println(Arrays.toString(ss(arr,6)));
    }

    //45ms
//    static int[] twoSum(int[] arr,int target){
//
//
//        //run the steps n-1 times
//        int i=0;
//        while(true){
//            i++;
//            //for each step, max item will come at the last respective index
//            for (int j=i+1;j<arr.length-i;j++){
//                if (arr[i]+arr[j]==target){
//                    return new int[]{i,j};
//                }
//            }
//        }
//    }

    //0ms
    static int[] ss(int[] arr,int target){

        int i=0;
        while(true){
            i++;
            //for each step, max item will come at the last respective index
            for (int j=0;j<arr.length-i;j++){
                if (arr[j]+arr[i+j]==target){
                    return new int[]{j,i+j};
                }
            }
        }
    }
}
