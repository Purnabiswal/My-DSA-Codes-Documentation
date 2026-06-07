package src.T_18_DP.Day_8_MCM_DP;

import java.util.Arrays;

//LC_312
//https://www.naukri.com/code360/problems/burst-balloons_628471
public class DP_51_BurstBalloons {
    public static void main(String[] args) {

        int[] nums={3,1,5,8};
//        int[] nums={1,5};
        System.out.println(maxCoins(nums));
        System.out.println(maxCoins2(nums));
        System.out.println(maxCoins3(nums));
    }

    static public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for (int i = 1; i < n+1; i++) {
            arr[i]=nums[i-1];
        }

        return f(1, n, arr);
    }

    static public int f(int i, int j, int[] arr){
        if(i>j) return 0;

        int max=Integer.MIN_VALUE, coins;
        for (int k = i; k <= j; k++) {
            coins=(arr[i-1]*arr[k]*arr[j+1])+f(i, k-1, arr)+f(k+1, j, arr);
            if (coins>max) max=coins;
        }

        return max;
    }


    //Memo
    //TC: O(n^3)
    //SC: O(n^2) + O(n)
    static public int maxCoins2(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for (int i = 1; i < n+1; i++) {
            arr[i]=nums[i-1];
        }

        int[][] dp=new int[n+1][n+1];
        for (int[] e:dp){
            Arrays.fill(e, -1);
        }

        return f2(1, n, arr, dp);
    }

    static public int f2(int i, int j, int[] arr, int[][] dp){
        if(i>j) return 0;

        if (dp[i][j]!=-1){
            return dp[i][j];
        }

        int max=Integer.MIN_VALUE, coins;
        for (int k = i; k <= j; k++) {
            coins=(arr[i-1]*arr[k]*arr[j+1])+f2(i, k-1, arr, dp)+f2(k+1, j, arr, dp);
            if (coins>max) max=coins;
        }

        return dp[i][j]=max;
    }



    //Tabulation
    //TC: O(n^3)
    //SC: O(n^2)
    static public int maxCoins3(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for (int i = 1; i < n+1; i++) {
            arr[i]=nums[i-1];
        }
        int[][] dp=new int[n+2][n+2];


        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int max=Integer.MIN_VALUE, coins;
                for (int k = i; k <= j; k++) {
                    coins=(arr[i-1]*arr[k]*arr[j+1])+dp[i][k-1]+dp[k+1][j];
                    if (coins>max) max=coins;
                }

                dp[i][j]=max;
            }
        }


        return dp[1][n];
    }


}
