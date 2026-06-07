package src.T_18_DP.Day_6_DpOnSocks;

import java.util.Arrays;

//LC_309
//https://www.naukri.com/code360/problems/highway-billboards_3125969
public class DP_39_BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {

    }


    //recursion
    //TC: O(2^n)
    //SC: O(n)
    static public int maxProfit(int[] prices) {
        return f(0, 1, prices);
    }
    static public int f(int n, int b, int[] arr){
        if (n == arr.length-1 && b==1) return 0;
        if (n == arr.length-1) return arr[n];

        int profit;
        if (b==1){
            profit=Math.max(f(n+1, 0, arr)-arr[n], f(n+1, 1, arr));
        }else {
            profit=Math.max(f(n+2, 1, arr)+arr[n], f(n+1, 0, arr));
        }
        return profit;
    }




    //memoization
    //TC: O(n*2)
    //SC: O(n*2) + O(n)
    static public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] e: dp){
            Arrays.fill(e, -1);
        }
        return f2(0, 1, prices, dp);
    }
    static public int f2(int n, int b, int[] arr, int[][] dp){
        if ((n == arr.length-1 && b==1) || n == arr.length) return 0;
        if (n == arr.length-1) return arr[n];

        if (dp[n][b]!=-1){
            return dp[n][b];
        }

        if (b==1){
            return dp[n][b] = Math.max(f2(n+1, 0, arr, dp)-arr[n], f2(n+1, 1, arr, dp));
        }else {
            return dp[n][b] = Math.max(f2(n+2, 1, arr, dp)+arr[n], f2(n+1, 0, arr, dp));
        }
    }


    //Tabulation
    //TC: O(n*2)
    //SC: O(n*2)
    static public int maxProfit3(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n-1][1]=0; //by default 0, so no need to write this
        dp[n][1]=0; //by default 0, so no need to write this

        dp[n-1][0]=prices[n-1];

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j==1){
                    dp[i][j]=Math.max(dp[i+1][0]-prices[i], dp[i+1][1]);
                }else {
                    dp[i][j]=Math.max(dp[i+2][1]+prices[i], dp[i+1][0]);
                }
            }
        }

        //Or
//        for (int i = n-2; i >= 0; i--) {
//            dp[i][1]=Math.max(dp[i+1][0]-prices[i], dp[i+1][1]);
//            dp[i][0]=Math.max(dp[i+2][1]+prices[i], dp[i+1][0]);
//        }

        return dp[0][1];
    }


    //More Space optimized solution won't create a better solution

    //Tabulation
    //TC: O(n)
    //Space optimized
    static public int maxProfit4(int[] prices) {
        int n = prices.length;
        int[] front1 = new int[2];
        int[] front2 = new int[2];
        front1[0]=prices[n-1];
        for (int i = n-2; i >= 0; i--) {
            int[] cur = new int[2];
            cur[1]=Math.max(front1[0]-prices[i], front1[1]);
            cur[0]=Math.max(front2[1]+prices[i], front1[0]);

            front2=front1;
            front1=cur;
        }
        return front1[1];
    }

}
