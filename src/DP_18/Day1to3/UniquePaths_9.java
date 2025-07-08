package src.DP_18.Day1to3;

import java.util.Arrays;

//Striver lecture-8 on DP
//Another solution to this problem is: Combinatorics.
public class UniquePaths_9 {
    public static void main(String[] args) {

        int m=6;
        int n=8;
        System.out.println(uniquePaths(m, n));
        System.out.println(uniquePaths2(m, n));
        System.out.println(uniquePaths3(m, n));
        System.out.println(uniquePaths4(m, n));
        System.out.println(uniquePaths5(m, n));
    }

    //Recursive
    //TC: O(2^(M*N))
    //SC: O((N-1)+(M-1))
    static public int uniquePaths(int m, int n) {
        return f(m-1, n-1);
    }
    static public int f(int m, int n){
        //base case
        if (m==0 && n==0){
            return 1; //found one possible path
        }

        int down = 0;
        if (m!=0){
            down = f(m-1, n);
        }
        int right = 0;
        if (n!=0){
            right = f(m, n-1);
        }

        return down+right;
    }

    //Memoization
    //TC: O(M*N)
    //SC: O((N-1)+(M-1)) + O(M*N)
    static public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return f2(m-1, n-1, dp);
    }
    static public int f2(int m, int n, int[][] dp){
        //base case
        if (m==0 && n==0){
            return 1; //found one possible path
        }
        if (dp[m][n]!=-1){
            return dp[m][n];
        }

        int down = 0;
        if (m!=0){
            down = f2(m-1, n, dp);
        }
        int right = 0;
        if (n!=0){
            right = f2(m, n-1, dp);
        }

        return dp[m][n] = down+right;
    }


    //Tabulation
    //TC: O(M*N)
    //SC: O(M*N)
    static public int uniquePaths3(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 || j==0){
                    dp[i][j]=1;
                }else {
                    int left=dp[i][j-1];
                    int up=dp[i-1][j];
                    dp[i][j]=left+up;
                }
            }
        }
        return dp[m-1][n-1];
    }

    //Tabulation
    //Space Optimized
    //TC: O(M*N)
    //SC: O(M)
    static public int uniquePaths4(int m, int n) {
        int[] prev = new int[n];
        int last=0;

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i==0 || j==0){
                    temp[j]=1;
                }else {
                    int up = prev[j];
                    temp[j] = last + up;
                }
                last=temp[j];
            }
            prev=temp;
        }
        return prev[n-1];
    }

    //Tabulation
    //Space Optimized
    //TC: O(M*N)
    //SC: O(min(M,N)
    static public int uniquePaths5(int m, int n) {
        int min = Math.min(m, n);
        int max = Math.max(m, n);
        int[] prev = new int[min];


        for (int i = 0; i < max; i++) {
            int[] temp = new int[min];
            int last=0;
            for (int j = 0; j < min; j++) {
                if (i==0 || j==0){
                    temp[j] = 1;
                }else {
                    int up = prev[j];
                    temp[j] = last + up;
                }
                last=temp[j];
            }
            prev=temp;
        }
        return prev[min-1];
    }


}
