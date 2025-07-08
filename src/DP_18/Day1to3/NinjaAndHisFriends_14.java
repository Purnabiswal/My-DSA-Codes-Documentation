package src.DP_18.Day1to3;


import java.util.Arrays;

//Chocolate Pickup
//LINK:
//Code360: https://www.naukri.com/code360/problems/ninja-and-his-friends_3125885
//Leetcode_1463: https://leetcode.com/problems/cherry-pickup-ii/description/

public class NinjaAndHisFriends_14 {
    public static void main(String[] args) {
        int[][] matrix = {
                {3,1,1,},
                {2,4,1},
                {1,5,5},
                {2,1,9},
        };

        System.out.println(cherryPickup(matrix));
        System.out.println(cherryPickup2(matrix));
        System.out.println(cherryPickup3(matrix));
        System.out.println(cherryPickup4(matrix));


    }

    //Recursion
    //Memoization
    //TC: O(9^M)
    //SC: O(M)
    static public int cherryPickup(int[][] grid) {
        int row = 0;
        int col1 = 0;
        int col2 = grid[0].length-1;
        int n= grid.length;

        return f(0, 0, col2, grid);
    }
    public static int f(int row, int col1, int col2, int[][] grid) {
        if (col1 <0 || col2<0 || col1 >= grid[0].length || col2 >= grid[0].length){
            return Integer.MIN_VALUE;
        }
        int cherries;
        if (col1 != col2){
            cherries = grid[row][col1] + grid[row][col2];
        }else {
            //when col1 == col2
            cherries = grid[row][col1];
        }
        //base case
        if (row== grid.length-1){
            return cherries;
        }
        int max=Integer.MIN_VALUE;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                max=Math.max(max, f(row+1, col1+i, col2+j, grid));
            }
        }
        return max+cherries;
    }


    //Memoization
    //TC: O(M*N*N*9)
    //SC: O(M) + O(M*N*N)
    static public int cherryPickup2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        for (int[][] arr1:dp){
            for (int[] arr:arr1){
                Arrays.fill(arr, -1);
            }
        }

        return f2(0, 0, grid[0].length-1, grid, dp);
    }
    public static int f2(int row, int col1, int col2, int[][] grid, int[][][] dp) {
        if (col1 <0 || col2<0 || col1 >= grid[0].length || col2 >= grid[0].length){
            return Integer.MIN_VALUE;
        }
        if (dp[row][col1][col2]!=-1){
            return dp[row][col1][col2];
        }
        int cherries;
        if (col1 != col2){
            cherries = grid[row][col1] + grid[row][col2];
        }else {
            //when col1 == col2
            cherries = grid[row][col1];
        }
        //base case
        if (row == grid.length-1){
            return cherries;
        }
        int max=Integer.MIN_VALUE;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                max=Math.max(max, f2(row+1, col1+i, col2+j, grid, dp));
            }
        }
        return dp[row][col1][col2] = max+cherries;
    }


    //Tabulation
    //TC: O(M*N*N*9)
    //SC: O(M*N*N)
    static public int cherryPickup3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        //base case
        for (int col1 = 0; col1 < n; col1++) {
            for (int col2 = 0; col2 < n; col2++) {
                if (col1 != col2){
                    dp[m-1][col1][col2] = grid[m-1][col1] + grid[m-1][col2];
                }else {
                    dp[m-1][col1][col2] = grid[m-1][col1];
                }
            }
        }
        for (int row = m-2; row >= 0; row--) {
            for (int col1 = n-1; col1 >= 0; col1--) {
                for (int col2 = n-1; col2 >= 0; col2--) {
                    int max=Integer.MIN_VALUE;
                    for (int p = -1; p < 2; p++) {
                        for (int q = -1; q < 2; q++) {
                            int r1=col1+p;
                            int r2=col2+q;
                            if (r1>=0 && r1<n && r2>=0 && r2<n){
                                max=Math.max(max, dp[row+1][r1][r2]);
                            }
                        }
                    }
                    int cherries;
                    if (col1 != col2){
                        cherries = grid[row][col1] + grid[row][col2];
                    }else {
                        cherries = grid[row][col1];
                    }
                    dp[row][col1][col2] = max+cherries;

                }
            }
        }

        return dp[0][0][n-1];
    }


    //Tabulation
    //Space optimization
    //TC: O(M*N*N*9)
    //SC: O(N*N)
    static public int cherryPickup4(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[n][n];
        //base case
        for (int col1 = 0; col1 < n; col1++) {
            for (int col2 = 0; col2 < n; col2++) {
                if (col1 != col2){
                    dp[col1][col2] = grid[m-1][col1] + grid[m-1][col2];
                }else {
                    dp[col1][col2] = grid[m-1][col1];
                }
            }
        }
        for (int row = m-2; row >= 0; row--) {
            int[][] cur = new int[n][n];
            for (int col1 = n-1; col1 >= 0; col1--) {
                for (int col2 = n-1; col2 >= 0; col2--) {
                    int max=Integer.MIN_VALUE;
                    for (int p = -1; p < 2; p++) {
                        for (int q = -1; q < 2; q++) {
                            int r1=col1+p;
                            int r2=col2+q;
                            if (r1>=0 && r1<n && r2>=0 && r2<n){
                                max=Math.max(max, dp[r1][r2]);
                            }
                        }
                    }
                    int cherries;
                    if (col1 != col2){
                        cherries = grid[row][col1] + grid[row][col2];
                    }else {
                        cherries = grid[row][col1];
                    }
                    cur[col1][col2] = max+cherries;
                }
            }
            dp=cur;
        }
        return dp[0][n-1];
    }




}
