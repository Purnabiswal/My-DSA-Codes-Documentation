package src.T_18_DP.Day_6_DpOnSocks;

import java.util.Arrays;

//LC_122
//https://www.naukri.com/code360/problems/best-time-to-buy-and-sell-stock-ii_630282
public class DP_36_BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {

        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit10(prices));
        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit3(prices));
        System.out.println(maxProfit4(prices));
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
            profit=Math.max(f(n+1, 1, arr)+arr[n], f(n+1, 0, arr));
        }
        return profit;
    }



    //recursion
    //TC: O(2^n)
    //SC: O(n)
    static public int maxProfit10(int[] prices) {
        return f10(0, true, prices);
    }
    static public int f10(int n, boolean b, int[] arr){
        if (n == arr.length-1 && b) return 0;
        if (n == arr.length-1) return arr[n];

        int profit;
        if (b){
            profit=Math.max(f10(n+1, false, arr)-arr[n], f10(n+1, true, arr));
        }else {
            profit=Math.max(f10(n+1, true, arr)+arr[n], f10(n+1, false, arr));
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
        if (n == arr.length-1 && b==1) return 0;
        if (n == arr.length-1) return arr[n];

        if (dp[n][b]!=-1){
            return dp[n][b];
        }

        if (b==1){
            return dp[n][b] = Math.max(f2(n+1, 0, arr, dp)-arr[n], f2(n+1, 1, arr, dp));
        }else {
            return dp[n][b] = Math.max(f2(n+1, 1, arr, dp)+arr[n], f2(n+1, 0, arr, dp));
        }
    }

    //Tabulation
    //TC: O(n*2)
    //SC: O(n*2)
    static public int maxProfit3(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[n-1][1]=0; //by default 0, so no need to write this
        dp[n-1][0]=prices[n-1];

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j==1){
                    dp[i][j]=Math.max(dp[i+1][0]-prices[i], dp[i+1][1]);
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
    static public int maxProfit4(int[] prices) {
        int n = prices.length;
        int[] prev = new int[2];
        prev[0]=prices[n-1];

        for (int i = n-2; i >= 0; i--) {
            int[] cur = new int[2];
            for (int j = 0; j <= 1; j++) {
                if (j==1){
                    cur[j]=Math.max(prev[0]-prices[i], prev[1]);
                }else {
                    cur[j]=Math.max(prev[1]+prices[i], prev[0]);
                }
            }
            prev=cur;
        }

        return prev[1];
    }

    //Tabulation
    //Space optimized - 4 variable method
    //TC: O(n*2)
    //SC: O(2)
    static public int maxProfit5(int[] prices) {
        int n = prices.length;

        int aheadBuy=0, aheadNotBuy=0, curBuy, curNotBuy;
        for (int i = n-1; i >= 0; i--) {
            curBuy=Math.max(aheadNotBuy-prices[i], aheadBuy);
            curNotBuy=Math.max(aheadBuy+prices[i], aheadNotBuy);
            aheadBuy=curBuy;
            aheadNotBuy=curNotBuy;
        }

        return aheadBuy;
    }

}
