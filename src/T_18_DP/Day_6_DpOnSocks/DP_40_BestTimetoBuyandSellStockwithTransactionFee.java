package src.T_18_DP.Day_6_DpOnSocks;

import java.util.Arrays;

//LC_714
//https://www.naukri.com/code360/problems/best-time-to-buy-and-sell-stock-with-transaction-fee_3118974
public class DP_40_BestTimetoBuyandSellStockwithTransactionFee {
    public static void main(String[] args) {

    }

    static public int maxProfit(int[] prices, int fee) {
        return f(0, 1, fee, prices);
    }
    static public int f(int n, int b, int f, int[] arr){
        if (n == arr.length) return 0;

        int profit;
        if (b==1){
            profit=Math.max(f(n+1, 0, f, arr)-arr[n]-f, f(n+1, 1, f, arr));
        }else {
            profit=Math.max(f(n+1, 1, f, arr)+arr[n], f(n+1, 0, f, arr));
        }
        return profit;
    }

    //memoization
    //TC: O(n*2)
    //SC: O(n*2) + O(n)
    static public int maxProfit2(int[] prices, int fee ) {
        int[][] dp = new int[prices.length][2];
        for(int[] e: dp){
            Arrays.fill(e, -1);
        }
        return f2(0, 1, fee, prices, dp);
    }
    static public int f2(int n, int b, int f, int[] arr, int[][] dp){
        if (n == arr.length-1 && b==1) return 0;
        if (n == arr.length-1) return arr[n];

        if (dp[n][b]!=-1){
            return dp[n][b];
        }

        if (b==1){
            return dp[n][b] = Math.max(f2(n+1, 0, f, arr, dp)-arr[n]-f, f2(n+1, 1, f, arr, dp));
        }else {
            return dp[n][b] = Math.max(f2(n+1, 1, f, arr, dp)+arr[n], f2(n+1, 0, f, arr, dp));
        }
    }



    //Tabulation
    //TC: O(n*2)
    //SC: O(n*2)
    static public int maxProfit3(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j==1){
                    dp[i][j]=Math.max(dp[i+1][0]-prices[i]-fee, dp[i+1][1]);
                }else {
                    dp[i][j]=Math.max(dp[i+1][1]+prices[i], dp[i+1][0]);
                }
            }
        }

        return dp[0][1];
    }


    //Tabulation
    //Space optimized
    //TC: O(n*2)
    //SC: O(2)
    static public int maxProfit4(int[] prices, int fee) {
        int n = prices.length;
        int[] prev = new int[2];
        prev[0]=prices[n-1];

        for (int i = n-2; i >= 0; i--) {
            int[] cur = new int[2];
            cur[1]=Math.max(prev[0]-prices[i]-fee, prev[1]);
            cur[0]=Math.max(prev[1]+prices[i], prev[0]);

            prev=cur;
        }

        return prev[1];
    }


    //Tabulation
    //Space optimized - 4 variable method
    //TC: O(n*2)
    //SC: O(2)
    static public int maxProfit5(int[] prices, int f) {
        int n = prices.length;

        int aheadBuy=0, curBuy=0, curNotBuy=0;
        for (int i = n-1; i >= 0; i--) {
            curBuy=Math.max(curNotBuy-prices[i]-f, curBuy);
            curNotBuy=Math.max(aheadBuy+prices[i], curNotBuy);
            aheadBuy=curBuy;
        }

        return curBuy;
    }

}
