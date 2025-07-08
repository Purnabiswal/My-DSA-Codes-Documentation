package src.DP_18.Day4;

//Link:
//https://leetcode.com/problems/coin-change/description/
//https://www.naukri.com/code360/problems/minimum-elements_3843091?
import java.util.Arrays;

//322. Coin Change
public class CoinChange_DP20 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int target = 11;
        System.out.println(coinChange(coins, target));
        System.out.println(coinChange2(coins, target));
        System.out.println(coinChange3(coins, target));
    }

    //Recursion
    //Exponential TC
    //TC: O(>>2^N) its more than 2^N as we are using infinity no. of coins
    //SC: O(>>N)
    static public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int res = f(n-1, amount, coins);
        return res==(int)1e9?-1:res;
    }
    static public int f(int n, int k, int[] arr) {
        if(k==0) return 0;
        if(n==0){
            if(k%arr[0]==0) return k/arr[0]; //arr[0] can be picked Infinity times
            return (int)1e9;
        }
        int pick=Integer.MAX_VALUE;
        if(k>=arr[n]){
            pick = f(n, k-arr[n], arr)+1; //Infinity picks
        }
        int nonPick = f(n-1, k, arr);

        return Math.min(pick, nonPick);
    }


    //Memoization
    //TC: O(N*W)
    //SC: O(N) + O(N*W)
    //where W: amount
    static public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] e:dp){
            Arrays.fill(e, -1);
        }
        int res = f2(n-1, amount, coins, dp);
        return res==(int)1e9?-1:res;
    }
    static public int f2(int n, int k, int[] arr, int[][] dp) {
        if(k==0) return 0;
        if(n==0){
            if(k%arr[0]==0) return k/arr[0];
            return (int)1e9;
        }
        if(dp[n][k]!=-1){
            return dp[n][k];
        }
        int pick1=Integer.MAX_VALUE;
        if(k>=arr[n]){
            pick1 = f2(n, k-arr[n], arr, dp)+1;
        }
        int nonPick = f2(n-1, k, arr, dp);

        return dp[n][k] = Math.min(pick1, nonPick);
    }

    //Tabulation
    //TC: O(N*W)
    //SC: O(N*W)
    //where W: amount
    static public int coinChange3(int[] arr, int amount) {
        int n = arr.length;
        int[][] dp = new int[n][amount+1];

        for(int k=0;k<=amount;k++){
            if(k%arr[0] == 0){
                dp[0][k] = k/arr[0];
            }else {
                dp[0][k] = (int)1e9;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                int pick = (int)1e9;
                if(j>=arr[i]){
                    pick = dp[i][j-arr[i]]+1;
                }
                int nonPick = dp[i-1][j];
                dp[i][j] = Math.min(pick, nonPick);
            }
        }

        int res = dp[n-1][amount];
        return res==(int)1e9?-1:res;
    }


    //Tabulation
    //Space Optimized
    //TC: O(N*W)
    //SC: O(W)
    //where W: amount
    static public int coinChange4(int[] arr, int amount) {
        int n = arr.length;
        int[] prev = new int[amount+1];

        for(int k=0;k<=amount;k++){
            if(k%arr[0] == 0){
                prev[k] = k/arr[0];
            }else {
                prev[k] = (int)1e9;
            }
        }

        for(int i=1;i<n;i++){
            int[] cur = new int[amount+1];
            for(int j=1;j<=amount;j++){
                int pick = (int)1e9;
                if(j>=arr[i]){
                    pick = cur[j-arr[i]]+1;
                }
                int nontPick = prev[j];
                cur[j] = Math.min(pick, nontPick);
            }
            prev = cur;
        }

        int res = prev[amount];
        return res==(int)1e9?-1:res;
    }

    //Tabulation
    //Space Optimized
    //Single array only
    //TC: O(N*W)
    //SC: O(W)
    //where W: amount
    static public int coinChange5(int[] arr, int amount) {
        int n = arr.length;
        int[] dp = new int[amount+1];

        for(int k=0;k<=amount;k++){
            if(k%arr[0] == 0){
                dp[k] = k/arr[0];
            }else {
                dp[k] = (int)1e9;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                int pick = (int)1e9;
                if(j>=arr[i]){
                    pick = dp[j-arr[i]]+1;
                }
                int nontPick = dp[j];
                dp[j] = Math.min(pick, nontPick);
            }
        }

        int res = dp[amount];
        return res==(int)1e9?-1:res;
    }




}
