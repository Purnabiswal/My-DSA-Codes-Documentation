package src.DP_18.Day1to3;

import java.util.Arrays;

//64. Minimum Path Sum. Medium
public class MinPathSum_11 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(minPathSum(grid));
        System.out.println(minPathSum2(grid));
        System.out.println(minPathSum3(grid));
        System.out.println(minPathSum4(grid));

    }


    //Recursion
    //TC: O(2^(M*N))
    //SC: O((M-1)+(N-1)) + O(M*N)
    static public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return minPathSum(m - 1, n - 1, grid);
    }

    static public int minPathSum(int m, int n, int[][] grid) {
        if (m == 0 && n == 0) return grid[0][0];


        int left = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;

        if (n > 0) {
            left = minPathSum(m, n-1, grid);
        }
        if (m > 0) {
            up = minPathSum(m-1, n, grid);
        }

        return Math.min(left, up) + grid[m][n];
    }


    //Memoization
    //TC: O(M*N)
    //SC: O((M-1)+(N-1)) + O(M*N)
    static public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp=new int[m][n];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return f(m - 1, n - 1, grid, dp);
    }

    static public int f(int m, int n, int[][] grid, int[][] dp) {
        if (m == 0 && n == 0) return grid[0][0];

        if (dp[m][n]!=-1){
            return dp[m][n];
        }

        int left = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;

        if (n > 0) {
            left = f(m, n-1, grid, dp);
        }
        if (m > 0) {
            up = f(m-1, n, grid, dp);
        }

        return dp[m][n] = Math.min(left, up) + grid[m][n];
    }

    //Tabulation
    //TC: O(M*N)
    //SC: O(M*N)
    static public int minPathSum3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp=new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 && j==0){
                    dp[i][j] = grid[i][j]; //base case
                }else {
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;
                    if (j > 0) {
                        left = dp[i][j-1];
                    }
                    if (i > 0) {
                        up = dp[i-1][j];
                    }
                    dp[i][j]=Math.min(left, up)+grid[i][j];
                }
            }
        }

        return dp[m-1][n-1];
    }

    //Tabulation
    //TC: O(M*N)
    //SC: O(N)
    static public int minPathSum4(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp=new int[n];

        for (int i = 0; i < m; i++) {
            int[] cur=new int[n];
            for (int j = 0; j < n; j++) {
                if (i==0 && j==0){
                    cur[j] = grid[i][j]; //base case
                }else {
                    int left = (j>0)?cur[j-1]:Integer.MAX_VALUE;
                    int up = (i>0)?dp[j]:Integer.MAX_VALUE;
                    cur[j]=Math.min(left, up)+grid[i][j];
                }
            }
            dp=cur;
        }

        return dp[n-1];
    }

}
