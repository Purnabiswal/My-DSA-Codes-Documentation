package src.T_18_DP.Day_6_DpOnSocks;


import java.util.Arrays;

//LC_123
//https://www.naukri.com/code360/problems/best-time-to-buy-and-sell-stock-iii_1071012
public class DP_37_BestTimetoBuyandSellStockIII {
    public static void main(String[] args) {
        int[] prices={3,3,5,0,0,3,1,4};
//        int[] prices={1,2,3,4,5};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit3(prices));
        System.out.println(maxProfit4(prices));
        System.out.println(maxProfit5(prices));
    }

    //recursion
    //TC: O(2^n)
    //SC: O(n)
    static public int maxProfit(int[] prices) {
        int n=prices.length;
        return f(0, 1, 2, prices);
    }
    static public int f(int i, int buy, int cap, int[] arr){
        if (i==arr.length) return 0;
        if (cap==0) return 0;

        if (buy==1){
            return Math.max(f(i+1, 0, cap, arr)-arr[i], f(i+1, 1, cap, arr));
        }else {
            return Math.max(f(i+1, 1, cap-1, arr)+arr[i], f(i+1, 0, cap, arr));
        }
    }





    //memo
    //TC: O(n*2*2)
    //SC: O(n*2*2) + O(n)
    static public int maxProfit2(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][2];
        for (int[][] e:dp){
            for (int[] arr:e){
                Arrays.fill(arr, -1);
            }
        }
        return f2(0, 1, 0, prices, dp);
    }
    static public int f2(int i, int b, int cap, int[] arr, int[][][] dp){
        if (cap==2) return 0;
        if (i==arr.length) return 0;

        if (dp[i][b][cap]!=-1){
            return dp[i][b][cap];
        }

        if (b==1){
            return dp[i][b][cap] = Math.max(f2(i+1, 0, cap, arr, dp)-arr[i], f2(i+1, 1, cap, arr, dp));
        }else {
            return dp[i][b][cap] = Math.max(f2(i+1, 1, cap+1, arr, dp)+arr[i], f2(i+1, 0, cap, arr, dp));
        }
    }




    //Tabulation
    //TC: O(n*2*3)
    //SC: O(n*2*3)
    static public int maxProfit3(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    if (j==1){
                        dp[i][j][k]=Math.max(dp[i+1][0][k]-prices[i], dp[i+1][1][k]);
                    }else {
                        dp[i][j][k]=Math.max(dp[i+1][1][k+1]+prices[i], dp[i+1][0][k]);
                    }
                }
            }
        }


        return dp[0][1][0];
    }





    //Tabulation
    //Space optimized
    //TC: O(n*2)
    //SC: O(2*3)
    static public int maxProfit4(int[] prices) {
        int n=prices.length;
        int[][] ahead =new int[2][3];

        for (int i = n-1; i >= 0; i--) {
            int[][] cur =new int[2][3];
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    if (j==1){
                        cur[j][k]=Math.max(ahead[0][k]-prices[i], ahead[1][k]);
                    }else {
                        cur[j][k]=Math.max(ahead[1][k+1]+prices[i], ahead[0][k]);
                    }
                }
            }
            ahead = cur;
        }


        return ahead[1][0];
    }



    //Tabulation
    //More Space optimized
    //TC: O(n*2)
    //SC: O()
    static public int maxProfit5(int[] prices) {
        int n=prices.length;

        //12 variables
        int aheadBC0=0, aheadNBC0=0, aheadBC1=0, aheadNBC1=0, curBC0, curNBC0, curBC1, curNBC1;
        for (int i = n-1; i >= 0; i--) {
            int[][] cur =new int[2][3];
            curBC0=Math.max(aheadNBC0-prices[i], aheadBC0);
            curNBC0=Math.max(aheadBC1+prices[i], aheadNBC0);
            curBC1=Math.max(aheadNBC1-prices[i], aheadBC1);
            curNBC1=Math.max(prices[i], aheadNBC1);

            aheadBC0=curBC0;
            aheadNBC0=curNBC0;
            aheadBC1=curBC1;
            aheadNBC1=curNBC1;
        }


        return aheadBC0;
    }


    static public int maxProfit6(int[] prices) {
        int n=prices.length;

        int aheadBC0=0, aheadNBC0=0, aheadBC1=0, aheadNBC1=0, curBC0, curNBC0, curBC1, curNBC1;
        for (int i = n-1; i >= 0; i--) {
            curBC0=Math.max(aheadNBC0-prices[i], aheadBC0);
            curNBC0=Math.max(aheadBC1+prices[i], aheadNBC0);
            curBC1=Math.max(aheadNBC1-prices[i], aheadBC1);
            curNBC1=Math.max(prices[i], aheadNBC1);

            aheadBC0=curBC0;
            aheadNBC0=curNBC0;
            aheadBC1=curBC1;
            aheadNBC1=curNBC1;
        }


        return aheadBC0;
    }

    public int maxProfit7(int[] prices) {
        int a=0, b=0, c=0, d=0, p;
        for (int i = prices.length-1; i >= 0; i--) {
            p=prices[i];
            a=Math.max(b-p, a);
            b=Math.max(c+p, b);
            c=Math.max(d-p, c);
            d=Math.max(p, d);
        }
        return a;
    }


}
