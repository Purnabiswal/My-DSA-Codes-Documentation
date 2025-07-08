package src.DP_18.Day4;

//2035. Partition Array Into Two Arrays to Minimize Sum Difference.

//Code 360: https://www.naukri.com/code360/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494
//DP_16

import java.util.Arrays;

public class PartitionArrayIntoTwoArraysToMinimizeSumDifference_3 {
    public static void main(String[] args) {
        int[] arr={0,0,0,15};

        System.out.println(minSubsetSumDifference(arr, arr.length));
        System.out.println(minSubsetSumDifference2(arr, arr.length));
        System.out.println(minSubsetSumDifference3(arr, arr.length));

    }

    //The below solution is for the Code360 problem and not for the Leetcode problem (as leetcode 2035 can be solved by diff algorithm).

    //Recursion
    //Wrong output in some test cases
    static public int minSubsetSumDifference(int[] nums, int n) {
        int totalSum=0;
        for (int i = 0; i < n; i++) {
            totalSum+=nums[i];
        }
        int target = totalSum/2;
        for (int i = target; i >= 0; i--) {
            if (subsetSumToK(n, i, nums)){
                return Math.abs(totalSum-(2*i));
            }
        }
        return -1;
    }
    public static boolean subsetSumToK(int n, int k, int[] arr){
        // Write your code here.

        return f(n-1,  k, arr);
    }
    public static boolean f(int n, int k, int[] arr){
        if (k==0){
            return true;
        }
        if (k<0 || n<0){
            return false;
        }

        return f(n-1, k-arr[n], arr) || f(n-1, k, arr);
    }



    //Memoization
    //Correct output
    static public int minSubsetSumDifference2(int[] nums, int n) {
        float totalSum=0;
        for (int i = 0; i < n; i++) {
            totalSum+=nums[i];
        }
        float target =  totalSum /2 ;

        float[][] dp = new float[n][(int)target+1];
        for (float[] e:dp){
            Arrays.fill(e, -1);
        }
        float ans=f10(n-1,  target, nums, dp);
        return (int)(2*ans);
    }
    public static float f10(int n, float k, int[] arr, float[][] dp){
        if (k==0){
            return 0;
        }
        if (n==0){
            float inc=k-arr[0];
            if (inc==0){
                return 0;
            }
            if (inc<0){
                return k;
            }
            return Math.min(inc, k);
        }
        if (dp[n][(int)k]!=-1){
            return dp[n][(int)k];
        }

        float nonTake = f10(n-1, k, arr, dp);
        float take = Integer.MAX_VALUE;
        if (k>=arr[n]){
            take = f10(n-1, k-arr[n], arr, dp);
        }

        return dp[n][(int)k] = Math.min(take, nonTake);
    }


    //Tabulation
    //Correct output
    //SubsetSumEqualK_1 file
    public static int minSubsetSumDifference3(int[] arr, int n){
        int totalSum=0;
        for (int i = 0; i < n; i++) {
            totalSum+=arr[i];
        }
        int k = totalSum /2;
        boolean[][] dp = new boolean[n][k+1];

        for (int i = 0; i < n; i++) {
            dp[i][0]=true;
        }

        if (arr[0]<=k){
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                boolean nonTake = dp[i-1][j];
                boolean take = false;
                if (j>=arr[i]){
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = take || nonTake;

            }
        }

        for (boolean[] e:dp){
            System.out.println(Arrays.toString(e));
        }

        for (int i = k; i >= 0; i--) {
            if (dp[n-1][i]){
                return totalSum-(2*i);
            }
        }

        return 0;
    }







}
