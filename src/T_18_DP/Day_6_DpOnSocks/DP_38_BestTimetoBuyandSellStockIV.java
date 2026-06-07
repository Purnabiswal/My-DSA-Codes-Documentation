package src.T_18_DP.Day_6_DpOnSocks;

import java.util.Arrays;

//LC_188
//https://www.naukri.com/code360/problems/best-time-to-buy-and-sell-stock_1080698
public class DP_38_BestTimetoBuyandSellStockIV {
    public static void main(String[] args) {

    }



    static public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][k+1];
        for (int[][] e:dp){
            for (int[] arr:e){
                Arrays.fill(arr, -1);
            }
        }
        return f2(0, 1, k, prices, dp);
    }
    static public int f2(int i, int b, int cap, int[] arr, int[][][] dp){
        if (cap==0) return 0;
        if (i==arr.length) return 0;

        if (dp[i][b][cap]!=-1){
            return dp[i][b][cap];
        }

        if (b==1){
            return dp[i][b][cap] = Math.max(f2(i+1, 0, cap, arr, dp)-arr[i], f2(i+1, 1, cap, arr, dp));
        }else {
            return dp[i][b][cap] = Math.max(f2(i+1, 1, cap-1, arr, dp)+arr[i], f2(i+1, 0, cap, arr, dp));
        }
    }



    //Tabulation
    //TC: O(n*2*3)
    //SC: O(n*2*3)
    static public int maxProfit2(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][k+1];

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (j==1){
                        dp[i][j][cap]=Math.max(dp[i+1][0][cap]-prices[i], dp[i+1][1][cap]);
                    }else {
                        dp[i][j][cap]=Math.max(dp[i+1][1][cap-1]+prices[i], dp[i+1][0][cap]);
                    }
                }
            }
        }


        return dp[0][1][k];
    }













    //Another way: Strivers way

    //recursion
    static public int maxProfit3(int k, int[] prices) {
        int n=prices.length;

        return f3(0, 0, k, prices);
    }
    static public int f3(int i, int tranNo, int k, int[] arr){
        if (tranNo==2*k || i==arr.length) return 0;

        if (tranNo%2==0){ //even for buy
            return Math.max(f3(i+1, tranNo+1, k, arr)-arr[i], f3(i+1, tranNo, k, arr));
        }else {
            return Math.max(f3(i+1, tranNo+1, k, arr)+arr[i], f3(i+1, tranNo, k, arr));
        }
    }




    //memo
    public int maxProfit4(int k, int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2*k];
        for (int[] e:dp){
            Arrays.fill(e, -1);
        }
        return f4(0, 0, k, prices, dp);
    }
    public int f4(int i, int tranNo, int k, int[] arr, int[][] dp){
        if (tranNo==2*k || i==arr.length) return 0;

        if (dp[i][tranNo]!=-1){
            return dp[i][tranNo];
        }

        if (tranNo%2==0){ //even for buy
            return dp[i][tranNo] = Math.max(f4(i+1, tranNo+1, k, arr, dp)-arr[i], f4(i+1, tranNo, k, arr, dp));
        }else {
            return dp[i][tranNo] = Math.max(f4(i+1, tranNo+1, k, arr, dp)+arr[i], f4(i+1, tranNo, k, arr, dp));
        }
    }




    //Tabulation
    public int maxProfit5(int k, int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2*k+1];


        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < 2*k; j++) {
                if (j%2==0){
                    dp[i][j]=Math.max(dp[i+1][j+1]-prices[i], dp[i+1][j]);
                }else {
                    dp[i][j]=Math.max(dp[i+1][j+1]+prices[i], dp[i+1][j]);
                }
            }
        }


        return dp[0][0] ;
    }


    //Tabulation
    //Space optimized
    public int maxProfit6(int k, int[] prices) {
        int n=prices.length;
        int[] ahead =new int[2*k+1];


        for (int i = n-1; i >= 0; i--) {
            int[] cur=new int[2*k+1];
            for (int j = 0; j < 2*k; j++) {
                if (j%2==0){
                    cur[j]=Math.max(ahead[j+1]-prices[i], ahead[j]);
                }else {
                    cur[j]=Math.max(ahead[j+1]+prices[i], ahead[j]);
                }
            }
            ahead=cur;
        }


        return ahead[0];
    }


    //Tabulation
    //More Space optimized
    public int maxProfit7(int k, int[] prices) {
        int n=prices.length;
        int[] cur =new int[2*k+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < 2*k; j++) {
                if (j%2==0){
                    cur[j]=Math.max(cur[j+1]-prices[i], cur[j]);
                }else {
                    cur[j]=Math.max(cur[j+1]+prices[i], cur[j]);
                }
            }
        }
        return cur[0];
    }


}
