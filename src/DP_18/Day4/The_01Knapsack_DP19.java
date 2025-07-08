package src.DP_18.Day4;

import java.util.ArrayList;
import java.util.Arrays;

//Link
//Coding Ninjas: https://www.naukri.com/code360/problems/0-1-knapsack_1072980?count=25&page=1&search=0%201%20Kna&sort_entity=order&sort_order=ASC&leftPanelTabValue=PROBLEM&customSource=studio_nav
//DP_19
//0 1 Knapsack

public class The_01Knapsack_DP19 {
    public static void main(String[] args) {

    }

    //Recursion
    //TC: O(2^N)
    //SC: O(N)
    //Note: W is max bag capacity.
    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        return f(values, weights, n-1, w);
    }
    public static int f(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        if(w==0) return 0;
        if(n==0){
            if(w>=weights.get(0)) return values.get(0);
            return 0;
        }

        int nonPick = f(values, weights, n-1, w);
        int pick = 0;
        if(w >= weights.get(n)){
            pick = f(values, weights, n-1, w-weights.get(n)) + values.get(n);
        }
        return Math.max(nonPick, pick);
    }


    //Memoization
    //TC: O(N*W)
    //SC: O(N) + O(N*W)
    public static int maxProfit2(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[][] dp = new int[n][w+1];
        for(int[] e:dp){
            Arrays.fill(e,-1);
        }
        return f2(values, weights, n-1, w, dp);
    }

    public static int f2(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w, int[][] dp) {
        if(w==0) return 0;
        if(n==0){
            if(w>=weights.get(0)) return values.get(0);
            return 0;
        }
        if(dp[n][w] != -1){
            return dp[n][w];
        }

        int nonPick = f2(values, weights, n-1, w, dp);
        int pick = 0;
        if(w >= weights.get(n)){
            pick = f2(values, weights, n-1, w-weights.get(n), dp) + values.get(n);
        }
        return dp[n][w] = Math.max(nonPick, pick);
    }

    //Tabulation
    //TC: O(N*W)
    //SC: O(N*W)
    public static int maxProfit3(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[][] dp = new int[n][w+1];

        int w0=weights.get(0);
        for (int i = w0; i <= w; i++) {
            dp[0][i] = values.get(0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= w; j++) {
                int nonPick = dp[i-1][j];
                int pick = 0;
                if(j >= weights.get(i)){
                    pick = dp[i-1][j-weights.get(i)] + values.get(i);
                }
                dp[i][j] = Math.max(nonPick, pick);
            }
        }

        return dp[n-1][w];
    }

    //Tabulation
    //Space Optimized
    //TC: O(N*W)
    //SC: O(W)
    public static int maxProfit4(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[] prev = new int[w+1];
        int w0=weights.get(0);
        for (int i = w0; i <= w; i++) {
            prev[i] = values.get(0);
        }

        for (int i = 1; i < n; i++) {
            int[] cur = new int[w+1];
            for (int j = 0; j <= w; j++) {
                int nonPick = prev[j];
                int pick = 0;
                if(j >= weights.get(i)){
                    pick = prev[j-weights.get(i)] + values.get(i);
                }
                cur[j] = Math.max(nonPick, pick);
            }
            prev = cur;
        }

        return prev[w];
    }


    //Tabulation
    //Space Optimized
    //Single row or array. Without any temp array.
    //TC: O(N*W)
    //SC: O(W)
    public static int maxProfit5(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[] prev = new int[w+1];
        int w0=weights.get(0);
        for (int i = w0; i <= w; i++) {
            prev[i] = values.get(0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = w; j >= 0; j--) {
                int nonPick = prev[j];
                int pick = 0;
                if(j >= weights.get(i)){
                    pick = prev[j-weights.get(i)] + values.get(i);
                }
                prev[j] = Math.max(nonPick, pick);
            }
        }

        return prev[w];
    }

}
