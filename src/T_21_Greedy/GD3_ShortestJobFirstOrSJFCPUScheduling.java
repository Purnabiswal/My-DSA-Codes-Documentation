package src.T_21_Greedy;

import java.util.Arrays;

//LeetCode que not found
public class GD3_ShortestJobFirstOrSJFCPUScheduling {
    public static void main(String[] args) {

    }


    int sjf(int[] arr){
        int t=0;
        int wt_time=0;
        Arrays.sort(arr);
        int n= arr.length;

        for (int i = 0; i < n-1; i++) {
            wt_time+=t;
            t+=arr[i];
        }

        return (wt_time/n);
    }




}
