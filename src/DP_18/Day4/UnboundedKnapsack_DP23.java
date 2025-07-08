package src.DP_18.Day4;

// Unbounded Knapsack
//Link:
//CodingNinjas: https://www.naukri.com/code360/problems/unbounded-knapsack_1215029

import java.util.Arrays;

public class UnboundedKnapsack_DP23 {
    public static void main(String[] args) {

    }

    //Recursion
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        return f(n-1, w, profit, weight);
    }

    public static int f(int n, int w, int[] pr, int[] wt){
        if(w==0){
            return 0;
        }
//        if(n==0){
//            if(w%wt[0] == 0) return (w/wt[0])*pr[0]; //This works in all the cases
//            return (int)-1e9;
//        }
        if(n==0){
            return (w/wt[0])*pr[0]; //This only works when asked by default return 0
        }

        int pick = (int)-1e9;
        if(w>=wt[n]){
            pick = f(n, w-wt[n], pr, wt);
        }
        int nonPick = f(n-1, w, pr, wt);
        return Math.max(pick, nonPick);
    }


    //Memoization
    public static int unboundedKnapsack2(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];
        for(int[] e:dp){
            Arrays.fill(e, -1);
        }
        int res = f2(n-1, w, profit, weight, dp);
        return res==(int)-1e9?0:res;
    }

    public static int f2(int n, int w, int[] pr, int[] wt, int[][] dp){
        if(w==0){
            return 0;
        }
        if(n==0){
            return (w/wt[0])*pr[0];
        }

        if(dp[n][w] != -1){
            return dp[n][w];
        }

        int pick = (int)-1e9;
        if(w>=wt[n]){
            pick = f2(n, w-wt[n], pr, wt, dp)+pr[n];
        }
        int nonPick = f2(n-1, w, pr, wt, dp);
        return dp[n][w] = Math.max(pick, nonPick);
    }


    //Tabulation
    public static int unboundedKnapsack3(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];

        for(int j=0;j<=w;j++){
            if(j%weight[0]==0){
                dp[0][j] = (j/weight[0])*profit[0];
            }else{
                dp[0][j] = (int)-1e9;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=w;j++){
                int pick = (int)-1e9;
                if(j>=weight[i]){
                    pick = dp[i][j-weight[i]]+profit[i];
                }
                int nonPick = dp[i-1][j];
                dp[i][j] = Math.max(pick, nonPick);
            }
        }

        return dp[n-1][w] == (int)-1e9?0:dp[n-1][w];
    }


    //Tabulation
    //Space Optimized
    public static int unboundedKnapsack4(int n, int w, int[] profit, int[] weight) {
        int[] prev = new int[w+1];

        //Base case
        for(int j=0;j<=w;j++){
            if(j%weight[0]==0){
                prev[j] = (j/weight[0])*profit[0];
            }else{
                prev[j] = (int)-1e9;
            }
        }

        for(int i=1;i<n;i++){
            int[] cur = new int[w+1];
            for(int j=1;j<=w;j++){
                int pick = (int)-1e9;
                if(j>=weight[i]){
                    pick = cur[j-weight[i]]+profit[i];
                }
                int nonPick = prev[j];
                cur[j] = Math.max(pick, nonPick);
            }
            prev = cur;
        }

        return prev[w] == (int)-1e9?0:prev[w];
    }


    //Tabulation
    //More Space Optimized
    //Single row version
    public static int unboundedKnapsack5(int n, int w, int[] profit, int[] weight) {
        int[] dp = new int[w+1];

        //Base case
        for(int j=0;j<=w;j++){
            if(j%weight[0]==0){
                dp[j] = (j/weight[0])*profit[0];
            }else{
                dp[j] = (int)-1e9;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=w;j++){
                int pick = (int)-1e9;
                if(j>=weight[i]){
                    pick = dp[j-weight[i]]+profit[i];
                }
                int nonPick = dp[j];
                dp[j] = Math.max(pick, nonPick);
            }
        }

        return dp[w] == (int)-1e9?0:dp[w];
    }



    //Final
    public static int unboundedKnapsack6(int n, int w, int[] profit, int[] weight) {
        int[] dp = new int[w+1];
        //Base case
        for(int j=0;j<=w;j++){
            dp[j] = (j/weight[0])*profit[0];
        }
        for(int i=1;i<n;i++){
            for(int j=weight[i];j<=w;j++){
                dp[j] = Math.max(dp[j-weight[i]]+profit[i], dp[j]);
            }
        }
        return dp[w];
    }

}
