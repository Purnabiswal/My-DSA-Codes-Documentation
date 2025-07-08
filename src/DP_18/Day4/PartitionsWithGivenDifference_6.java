package src.DP_18.Day4;

import java.util.Arrays;

//DP_18
//Link:
//Code360: https://www.naukri.com/code360/problems/partitions-with-given-difference_3751628
public class PartitionsWithGivenDifference_6 {
    public static void main(String[] args) {
        int[] arr = {1,0,8,5,1,4};
        int d=17;
        int n=arr.length;
        System.out.println(countPartitions(n, d, arr));
        System.out.println(countPartitions2(n, d, arr));
        System.out.println(countPartitions3(n, d, arr));
        System.out.println(countPartitions4(n, d, arr));


    }
    static int mod = 1000000007;

    //Recursion
    //TC: O(2^(N*K))
    //SC: O(N)
    public static int countPartitions(int n, int d, int[] arr) {
        int toSum=0;
        for (int i = 0; i < n; i++) {
            toSum+=arr[i];
        }
        int div = toSum-d;
        if (div%2!=0 || div<0) return 0;
        int k = div/2; //k: Target
        return f(n-1, k, arr);
    }
    public static int f(int n, int k, int[] arr) {
        if (n==0){
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
    public static int countPartitions2(int n, int d, int[] arr) {
        int toSum=0;
        for (int i = 0; i < n; i++) {
            toSum+=arr[i];
        }
        int div = toSum-d;
        if (div%2!=0 || div<0) return 0;
        int k = div/2; //k: Target

        int[][] dp = new int[n][k+1];
        for (int[] e:dp){
            Arrays.fill(e, -1);
        }

        return f2(n-1, k, arr, dp);
    }
    //Count the number of paths
    public static int f2(int n, int k, int[] arr, int[][] dp) {
        if (n==0){
            if (k==0 && arr[0]==0) return 2;
            if (k==0 || arr[0]==k) return 1;
            return 0;
        }
        if (dp[n][k]!=-1){
            return dp[n][k];
        }

        int nonPick = f2(n-1, k, arr, dp);
        int pick = 0;
        if (k>=arr[n]){
            pick = f2(n-1, k-arr[n], arr, dp);
        }
        return dp[n][k] = pick+nonPick;
    }



    //Tabulation
    //TC: O(N*K)
    //SC: O(N*K)
    public static int countPartitions3(int n, int d, int[] arr) {
        int toSum=0;
        for (int i = 0; i < n; i++) {
            toSum+=arr[i];
        }
        int div = toSum-d;
        if (div%2!=0 || div<0) return 0;
        int k = div/2; //k: Target
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
    public static int countPartitions4(int n, int d, int[] arr) {
        int toSum=0;
        for (int i = 0; i < n; i++) {
            toSum+=arr[i];
        }
        int div = toSum-d;
        if (div%2!=0 || div<0) return 0;
        int k = div/2; //k: Target
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
            int[] cur = new int[k+1];
            for (int j = 0; j <= k; j++) {
                int nonPick = prev[j];
                int pick = 0;
                if (j>=arr[i]){
                    pick = prev[j-arr[i]];
                }
                cur[j] = (pick+nonPick)%mod;
            }
            prev = cur;
        }
        return prev[k];
    }


}
