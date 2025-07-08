package src.DP_18.Day1to3;

import java.util.Arrays;

//931. Minimum Falling Path Sum of N*N matrix. Medium
public class MinimumFallingPathSum_13 {
    public static void main(String[] args) {
        int[][] matrix = {
                {-19,57,35},
                {-40,-5,25},
                {25,5,2},
        };

        System.out.println("Recursion: " + minFallingPathSum(matrix));
        System.out.println("Memoization: " + minFallingPathSum2(matrix));
        System.out.println("Tabulation 2D: " + minFallingPathSum3(matrix));
        System.out.println("Tabulation 1D: " + minFallingPathSum4(matrix));


    }


    //Recursion
    //TC: O(3^(N*N))
    //SC: O(N)
    static public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            min = Math.min(min, f(0, i, n, matrix));
        }
        return min;
    }
    static public int f(int i, int j, int n, int[][] matrix) {
        if (i == n-1){
            return matrix[i][j];
        }

        int leftDia = (j>0) ? f(i + 1, j-1, n, matrix): Integer.MAX_VALUE;
        int down = f(i + 1, j, n, matrix);
        int rightDia = (j<n-1) ? f(i + 1, j+1, n, matrix): Integer.MAX_VALUE;

        return Math.min(Math.min(leftDia, down), rightDia) + matrix[i][j];
    }


    //Memoization
    //TC: O(N*N) + O(N*N) + O(N*N)
    //SC: O(N) + O(N*N)
    static public int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int min=Integer.MAX_VALUE;
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(min, f2(0, i, n, matrix, dp));
        }
        return min;
    }
    static public int f2(int i, int j, int n, int[][] matrix, int[][] dp ) {
        if (i == n-1){
            return matrix[i][j];
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }

        int leftDia = (j>0) ? f2(i + 1, j-1, n, matrix, dp): Integer.MAX_VALUE;
        int down = f2(i + 1, j, n, matrix, dp);
        int rightDia = (j<n-1) ? f2(i + 1, j+1, n, matrix, dp): Integer.MAX_VALUE;

        return dp[i][j] = Math.min(Math.min(leftDia, down), rightDia) + matrix[i][j];
    }

    //Tabulation
    //TC: O(N*N) + O(N)
    //SC: O(N*N)
    static public int minFallingPathSum3(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];


        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i == n-1){
                    dp[i][j] = matrix[i][j];
                }else {
                    int leftDia = (j>0) ? dp[i+1][j-1]: Integer.MAX_VALUE;
                    int down = dp[i+1][j];
                    int rightDia = (j<n-1) ? dp[i+1][j+1]: Integer.MAX_VALUE;
                    dp[i][j] = Math.min(Math.min(leftDia, down), rightDia) + matrix[i][j];
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[0][i]);
        }

        return min;
    }

    //Tabulation
    //TC: O(N*N) + O(N)
    //SC: O(N)
    static public int minFallingPathSum4(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];


        for (int i = n-1; i >= 0; i--) {
            int[] cur = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == n-1){
                    cur[j] = matrix[i][j];
                }else {
                    int leftDia = (j>0) ? dp[j-1]: Integer.MAX_VALUE;
                    int down = dp[j];
                    int rightDia = (j<n-1) ? dp[j+1]: Integer.MAX_VALUE;
                    cur[j] = Math.min(Math.min(leftDia, down), rightDia) + matrix[i][j];
                }
            }
            dp = cur;
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[i]);
        }

        return min;
    }


}
