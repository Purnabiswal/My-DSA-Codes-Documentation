package src.DP_18.Day4;

import java.util.Arrays;

public class CoinChangeII_DP22 {
    public static void main(String[] args) {

    }

    //Recursion
    //    | Time: Exponential |
    //    | Space: More than O(tar) |
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int res = f(n-1, amount, coins);
        return res;
    }

    static public int f(int n, int k, int[] arr) {
        if(k==0) return 1;
        if(n==0){
            if(k%arr[0]==0) return 1; //arr[0] can be picked Infinity times
            return 0;
        }
        int pick=0;
        if(k>=arr[n]){
            pick = f(n, k-arr[n], arr); //Infinity picks
        }
        int nonPick = f(n-1, k, arr);

        return pick + nonPick;
    }


    //Memoization
    //    | Time   | O(n * tar) |
    //    | Space  | O(n * tar) + O(tar) |
    public int change2(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] e:dp){
            Arrays.fill(e, -1);
        }
        return f2(n-1, amount, coins, dp);
    }

    static public int f2(int n, int k, int[] arr, int[][] dp) {
        if(k==0) return 1;
        if(n==0){
            if(k%arr[0]==0) return 1; //arr[0] can be picked Infinity times
            return 0;
        }
        if(dp[n][k]!=-1){
            return dp[n][k];
        }
        int pick=0;
        if(k>=arr[n]){
            pick = f2(n, k-arr[n], arr, dp); //Infinity picks
        }
        int nonPick = f2(n-1, k, arr, dp);

        return dp[n][k] = pick + nonPick;
    }

    //Tabulation
    //    | Time   | O(n * tar) |
    //    | Space  | O(n * tar) |
    public int change3(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
        for(int t=1;t<=amount;t++){
            if(t%coins[0]==0){
                dp[0][t] = 1;
            }else{
                dp[0][t] = 0;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                int pick=0;
                if(j>=coins[i]){
                    pick=dp[i][j-coins[i]];
                }
                int nonPick=dp[i-1][j];
                dp[i][j] = pick + nonPick;
            }
        }

        return dp[n-1][amount];
    }

    //Tabulation
    //Space Optimized
    //    | Time   | O(n * tar) |
    //    | Space  | O(tar)     |
    public int change4(int tar, int[] arr) {
        int n = arr.length;
        int[] prev = new int[tar+1];

        prev[0] = 1;

        for(int t=1;t<=tar;t++){
            if(t%arr[0]==0){
                prev[t] = 1;
            }else{
                prev[t] = 0;
            }
        }

        for(int i=1;i<n;i++){
            int[] cur = new int[tar+1];
            cur[0] = 1;
            for(int j=1;j<=tar;j++){
                int pick=0;
                if(j>=arr[i]){
                    pick=cur[j-arr[i]];
                }
                int nonPick=prev[j];
                cur[j] = pick + nonPick;
            }
            prev = cur;
        }

        return prev[tar];
    }

    //Tabulation
    //Space Optimized.
    //Optimized into a single array
//    | Time   | O(n * tar) |
//    | Space  | O(tar)     |

    public int change5(int tar, int[] arr) {
        int n = arr.length;
        int[] dp = new int[tar+1];
        dp[0] = 1;
        for(int t=1;t<=tar;t++){
            if(t%arr[0]==0){
                dp[t] = 1;
            }else{
                dp[t] = 0;
            }
        }

        for(int i=1;i<n;i++){
            dp[0] = 1;
            for(int j=1;j<=tar;j++){
                int pick=0;
                if(j>=arr[i]){
                    pick=dp[j-arr[i]];
                }
                int nonPick=dp[j];
                dp[j] = pick + nonPick;
            }
        }

        return dp[tar];
    }

}
