package src.T_18_DP.Day_7_LIS;

import java.util.Arrays;

//LC_300
//https://www.naukri.com/code360/problems/longest-increasing-subsequence_1062665
public class DP_41_LongestIncreasingSubsequence {
    public static void main(String[] args) {

//        int[] a={10,9,2,5,3,7,101,18};
        int[] a={0,1,0,3,2,3};
//        int[] a={7,7,7,7,7,7,7};
//        int[] a={1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(a));
        System.out.println(lengthOfLIS1(a));
        System.out.println(lengthOfLIS2(a));
        System.out.println(lengthOfLIS6(a));
    }


    //New way
    //Important - all LIS questions are based on this solution
    //Tabulation
    //TC: O(n*n)
    //SC: O(n)
    static public int lengthOfLIS6(int[] a) {
        int n=a.length;
        int[] dp=new int[n];
        Arrays.fill(dp, 1); //Initially set all 1
        int max=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j]<a[i]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            max=Math.max(max, dp[i]);
        }

        return max;
    }








    //Recursion
    //TC: O(2n*2^n)
    //SC: O(n*n)
    static public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        return f(n-1, Integer.MAX_VALUE, nums);
    }

    static public int f(int n, int val, int[] a){
        if (n==0){
            if (a[0]<val) return 1;
            return 0;
        }

        int pick=Integer.MIN_VALUE;
        if (a[n]<val){
            pick = 1+f(n-1, a[n], a);
        }
        int nonPick = f(n - 1, val, a);

        return Math.max(pick, nonPick);
    }

    //Memo
    //TC: O(n*n)
    //SC: O(n*n)
    //correct solution- no problem with this
//    static public int lengthOfLIS2(int[] nums) {
//        int n=nums.length;
//        int[][] dp=new int[n][n+1];
//        for (int[] e:dp){
//            Arrays.fill(e, -1);
//        }
//        return f2(n-1, n, nums, dp);
//    }
//
//    static public int f2(int n, int val, int[] a, int[][] dp){
//        int len=a.length;
//        if (n==0){
//            if (val==len || a[0]<a[val]) return 1;
//            return 0;
//        }
//
//        if (dp[n][val]!=-1){
//            return dp[n][val];
//        }
//
//        int pick=Integer.MIN_VALUE;
//        if (val==len || a[n]<a[val]){
//            pick = 1+f2(n-1, n, a, dp);
//        }
//        int nonPick = f2(n-1, val, a, dp);
//
//        return dp[n][val]=Math.max(pick, nonPick);
//    }


    //Another way - strivers way

    //Recursion
    //TC: O(2n*2^n)
    //SC: O(n)
    static public int lengthOfLIS1(int[] nums) {
        int n=nums.length;

        return f1(0, -1, nums);
    }

    static public int f1(int i, int prev, int[] a){
        if (i==a.length) return 0;

        int pick=Integer.MIN_VALUE;
        if (prev==-1 || a[i]>a[prev]){
            pick = 1+f1(i+1, i, a);
        }
        int nonPick = f1(i+1, prev, a);

        return Math.max(pick, nonPick);
    }



    //Memo
    //TC: O(n*n)
    //SC: O(n*n) + O(n)
    static public int lengthOfLIS2(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n];
        for (int[] e:dp){
            Arrays.fill(e, -1);
        }
        return f2(1, 0, nums, dp);
    }
    static public int f2(int i, int prev, int[] a, int[][] dp){
        if (i==a.length+1) return 0;
        if (dp[i][prev]!=-1){
            return dp[i][prev];
        }

        int pick=Integer.MIN_VALUE;
        if (prev==0 || a[i-1]>a[prev-1]){
            pick = 1+f2(i+1, i, a, dp);
        }
        int nonPick = f2(i+1, prev, a, dp);

        return dp[i][prev]=Math.max(pick, nonPick);
    }

    //Tabulation
    //TC: O(n*n)
    //SC: O(n*n)
    static public int lengthOfLIS3(int[] a) {
        int n=a.length;
        int[][] dp=new int[n+2][n+1];

        for (int i = n; i >= 1; i--) {
            for (int j = n-1; j >= 0; j--) {
                int pick=Integer.MIN_VALUE;
                if (j==0 || a[i-1]>a[j-1]){
                    pick = 1+dp[i+1][i];
                }
                int nonPick = dp[i+1][j];
                dp[i][j]=Math.max(pick, nonPick);
            }
        }

        return dp[1][0];
    }




    static public int lengthOfLIS4(int[] a) {
        int n=a.length;
        int[] dp=new int[n+1];

        for (int i = n; i >= 1; i--) {
            int[] cur=new int[n+1];
            for (int j = n-1; j >= 0; j--) {
                int pick=Integer.MIN_VALUE;
                if (j==0 || a[i-1]>a[j-1]){
                    pick = 1+dp[i];
                }
                int nonPick = dp[j];
                cur[j]=Math.max(pick, nonPick);
            }
            dp=cur;
        }

        return dp[0];
    }



    //Tabulation
    //TC: O(n*n)
    //SC: O(n)
    static public int lengthOfLIS5(int[] a) {
        int n=a.length;
        int[] dp=new int[n+1];

        for (int i = n; i >= 1; i--) {
            for (int j = n-1; j >= 0; j--) {
                int pick=Integer.MIN_VALUE;
                if (j==0 || a[i-1]>a[j-1]){
                    pick = 1+dp[i];
                }
                int nonPick = dp[j];
                dp[j]=Math.max(pick, nonPick);
            }
        }

        return dp[0];
    }



}
