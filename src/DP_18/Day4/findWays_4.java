package src.DP_18.Day4;

import java.util.Arrays;

//Link
//Coding Ninjas: https://www.naukri.com/code360/problems/number-of-subsets_3952532
//DP_17
public class findWays_4 {
    public static void main(String[] args) {

        int[] arr = {1,1,1,1,1};
        int k = 3;

        System.out.println(findWays(arr, k));
        System.out.println(findWays1(arr, k));
        System.out.println(findWays2(arr, k));
        System.out.println(findWays3(arr, k));





    }

    //Recursion
    //TC: O(2^(N*K))
    //SC: O(N)
    public static int findWays(int[] num, int tar) {
        return f(num.length-1, tar, num);
    }
    public static int f(int n, int k, int[] arr){
        if(n==0){
            if (k==0 && arr[0]==0) return 2;
            if (k==0 || arr[0]==k) return 1;
            return 0;
        }

        int nonPick = f(n-1, k, arr);
        int pick = 0;
        if (k>=arr[n]){
            pick = f(n-1, k-arr[n], arr);
        }
        return pick+nonPick;
    }


    //Memoization
    //TC: O(N*K)
    //SC: O(N*K) + O(N)
    public static int findWays1(int[] num, int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        for (int[] e : dp){
            Arrays.fill(e, -1);
        }
        return f1(n-1, tar, num, dp);
    }
    public static int f1(int n, int k, int[] arr, int[][] dp){
        if(n==0){
            if (k==0 && arr[0]==0) return 2;
            if (k==0 || arr[0]==k) return 1;
            return 0;
        }
        if (dp[n][k]!=-1){
            return dp[n][k];
        }

        int nonPick = f1(n-1, k, arr, dp);
        int pick = 0;
        if (k>=arr[n]){
            pick = f1(n-1, k-arr[n], arr, dp);
        }
        return dp[n][k] = pick+nonPick;
    }
    //Handling zeroes with loops
//    public static int f1(int n, int k, int[] arr, int[][] dp){
//        if (k==0){
//            int ans=1;
//            for (int i = n; i >= 0; i--) {
//                if (arr[i]==0){
//                    ans++;
//                }
//            }
//            return ans;
//        }
//        if(n==0){
//            if (arr[0]==k){
//                return 1;
//            }
//            return 0;
//        }
//        if (dp[n][k]!=-1){
//            return dp[n][k];
//        }
//
//        int nonPick = f1(n-1, k, arr, dp);
//        int pick = 0;
//        if (k>=arr[n]){
//            pick = f1(n-1, k-arr[n], arr, dp);
//        }
//        return dp[n][k] = pick+nonPick;
//    }


    //Tabulation
    //TC: O(N*K)
    //SC: O(N*K)
    static int mod=1000000007;
    public static int findWays2(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k+1];
        if (arr[0]==0){
            dp[0][0]=2;
        }else {
            dp[0][0]=1;
            if (arr[0]<=k){
                dp[0][arr[0]]=1;
            }
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                int nonPick = dp[i-1][j];
                int pick = 0;
                if (j>=arr[i]){
                    pick = dp[i-1][j-arr[i]];
                }
                dp[i][j] = (pick+nonPick)%mod;
            }
        }

        return dp[n-1][k];
    }


    //Tabulation
    //Space Optimized
    //TC: O(N*K)
    //SC: O(K)
    public static int findWays3(int[] arr, int k) {
        int n = arr.length;
        int[] prev = new int[k+1];
        if (arr[0]==0){
            prev[0]=2;
        }else {
            prev[0]=1;
            if (arr[0]<=k){
                prev[arr[0]]=1;
            }
        }


        for (int i = 1; i < n; i++) {
            int[] temp = new int[k+1];
            for (int j = 0; j <= k; j++) {
                int nonPick = prev[j];
                int pick = 0;
                if (j>=arr[i]){
                    pick = prev[j-arr[i]];
                }
                temp[j] = pick+nonPick;
            }
            prev = temp;
        }

        return prev[k];
    }



}
